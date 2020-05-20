package com.api.thecat.typesofcat.config;

import com.mongodb.MongoClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "typesofcat")
public class TypesCatConfig {

    String teste;

}
