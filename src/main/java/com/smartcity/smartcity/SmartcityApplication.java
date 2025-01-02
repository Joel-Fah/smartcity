package com.smartcity.smartcity;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartcityApplication {

	public static void main(String[] args) {
		// Load the .env file
        Dotenv dotenv = Dotenv.load();

        // Set environment variables for Spring Boot to use
        System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
        System.setProperty("DATABASE_USER", dotenv.get("DATABASE_USER"));
        System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));

		SpringApplication.run(SmartcityApplication.class, args);
	}
}
