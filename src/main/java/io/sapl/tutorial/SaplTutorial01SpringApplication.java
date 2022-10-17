package io.sapl.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@SpringBootApplication
@EnableMongoRepositories
public class SaplTutorial01SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaplTutorial01SpringApplication.class, args);
	}

}
