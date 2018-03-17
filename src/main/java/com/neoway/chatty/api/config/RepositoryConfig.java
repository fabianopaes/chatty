package com.neoway.chatty.api.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="com.neoway.chatty.api.domain")
@EnableMongoAuditing
class RepositoryConfig extends AbstractMongoConfiguration {

    @Value("${database.uri:mongodb://mongodb:27017/chatty-database})")
    String uri;

    @Override
    protected String getDatabaseName() {
        return "chatty-database";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(uri));
    }
}
