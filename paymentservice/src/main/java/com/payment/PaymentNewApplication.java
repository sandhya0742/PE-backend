
package com.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
//@EnableEurekaClient
public class PaymentNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentNewApplication.class, args);
	}

}
