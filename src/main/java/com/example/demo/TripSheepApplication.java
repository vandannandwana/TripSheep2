package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TripSheepApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripSheepApplication.class, args);
	}

}
