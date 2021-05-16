package com.ltts.shadow.smartcafeteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartCafeteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartCafeteriaApplication.class, args);
	}

}
