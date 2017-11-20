package com.Revature.AccountService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "properties/AccountService");
		SpringApplication.run(AccountServiceApplication.class, args);
	}
}
