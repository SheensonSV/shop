package com.someshop.configs;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    /*
     * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
     */
    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }
    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "mydatabase");
    }
}
