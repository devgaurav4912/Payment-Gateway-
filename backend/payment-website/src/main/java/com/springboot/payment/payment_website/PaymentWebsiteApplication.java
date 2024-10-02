package com.springboot.payment.payment_website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentWebsiteApplication.class, args);

		System.out.println("Payment Application is started...");
	}

}
