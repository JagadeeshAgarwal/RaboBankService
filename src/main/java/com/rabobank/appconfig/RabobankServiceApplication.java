package com.rabobank.appconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

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
