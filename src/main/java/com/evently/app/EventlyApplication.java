package com.evently.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(/*exclude = {SecurityAutoConfiguration.class}*/)
public class EventlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventlyApplication.class, args);
	}

}