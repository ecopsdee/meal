package com.dexdee.meal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class FoodShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodShopApplication.class, args);
	}

}
