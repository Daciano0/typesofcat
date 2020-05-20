package com.api.thecat.typesofcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableDiscoveryClient
@EnableMongoAuditing
@EnableFeignClients
@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class TypesofcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypesofcatApplication.class, args);
	}

}
