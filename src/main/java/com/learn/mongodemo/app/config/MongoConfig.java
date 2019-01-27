package com.learn.mongodemo.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = { "com.learn.mongodemo.domain.repository" })
public class MongoConfig {

}
