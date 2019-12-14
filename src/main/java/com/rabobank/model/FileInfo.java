package com.rabobank.model;

public class FileInfo {
private String fileName;
private long fileSize;

private String errorReference;
private String errorDescription;

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public long getFileSize() {
	return fileSize;
}

public void setFileSize(long fileSize) {
	this.fileSize = fileSize;
}

public String getErrorReference() {
	return errorReference;
}

public void setErrorReference(String errorReference) {
	this.errorReference = errorReference;
}

public String getErrorDescription() {
	return errorDescription;
}

public void setErrorDescription(String errorDescription) {
	this.errorDescription = errorDescription;
}

}
