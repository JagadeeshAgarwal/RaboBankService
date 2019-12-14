package com.rabobank.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rabobank.model.CustomerStatementRecord;
import com.rabobank.model.FileInfo;

@RestController
public class CSVFileController {

    private static final Logger logger = LoggerFactory.getLogger(CSVFileController.class);

//    @Autowired
//    private FileStorageService fileStorageService;
    
    @Autowired
	ServletContext context;
    
    /*
     * This method will process the csv file input and retun the FileInfo object contains validation errors
     */
	@RequestMapping(value = "/csvFileUpload", headers=("content-type=multipart/*"), method = RequestMethod.POST)
 public ResponseEntity<FileInfo> csvFileUpload(@RequestParam("file") MultipartFile inputFile) {
		logger.info("Started Processing CSV file");
  FileInfo fileInfo = new FileInfo();
  HttpHeaders headers = new HttpHeaders();
  
  if (!inputFile.isEmpty()) {
   try {
    String originalFilename = inputFile.getOriginalFilename();
    File destinationFile = new File(context.getRealPath("/WEB-INF/uploaded")+  File.separator + originalFilename);
    inputFile.transferTo(destinationFile);
    fileInfo.setFileName(destinationFile.getPath());
    fileInfo.setFileSize(inputFile.getSize());
    headers.add("File Uploaded Successfully - ", originalFilename);
     BufferedReader reader = Files.newBufferedReader(Paths.get(originalFilename));
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
    List<CustomerStatementRecord> customerRecordList = new ArrayList<CustomerStatementRecord>();
    for (CSVRecord csvRecord : csvParser) {
    	CustomerStatementRecord cust= new CustomerStatementRecord();
        // Accessing Values by Column Index
    	cust.setAccountNumber(csvRecord.get(0));
    	cust.setDescription(csvRecord.get(1));
    	cust.setEndBalance(new BigDecimal(csvRecord.get(2)));
    	cust.setMutation(csvRecord.get(3));
    	cust.setStartBalance(new BigDecimal(csvRecord.get(4)));
    	cust.setTransReference(csvRecord.get(5));
        
    }

    logger.info("Successfully completed Processing CSV file");
    return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
   } catch (Exception e) {    
    return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
   }
  }else{
   return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
  }
 }
//    @PostMapping("/uploadFile")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }

  

}
