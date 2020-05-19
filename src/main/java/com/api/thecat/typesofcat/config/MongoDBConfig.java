package com.api.thecat.typesofcat.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.api.thecat.typesofcat.repository")
public class MongoDBConfig {


    public @Bean
    MongoDbFactory mongoDbFactory()  {
        return new SimpleMongoDbFactory(new MongoClient(), "test");
    }

    public @Bean
    MongoTemplate mongoTemplate()  {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;

    }

    @Bean
    public Query query(){
        return new org.springframework.data.mongodb.core.query.Query();
    }
}
