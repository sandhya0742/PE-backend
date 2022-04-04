package com.arshaa.loginsecurityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LoginSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSecurityServiceApplication.class, args);
	}

}
