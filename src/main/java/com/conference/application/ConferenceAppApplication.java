package com.conference.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ConferenceAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ConferenceAppApplication.class, args);
	}

}
