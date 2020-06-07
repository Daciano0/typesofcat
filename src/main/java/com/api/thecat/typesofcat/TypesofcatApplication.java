package com.api.thecat.typesofcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableDiscoveryClient
@EnableMongoAuditing
@SpringBootApplication
public class TypesofcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypesofcatApplication.class, args);
	}

}
