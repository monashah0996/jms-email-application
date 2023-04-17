package com.jms.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class JmsEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsEmailApplication.class, args);
	}

}
