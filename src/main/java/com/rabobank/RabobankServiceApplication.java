package com.rabobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.rabobank.utils.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class RabobankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabobankServiceApplication.class, args);
	}

}
