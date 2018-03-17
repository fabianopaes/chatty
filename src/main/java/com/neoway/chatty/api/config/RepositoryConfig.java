package com.neoway.chatty.api.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="com.neoway.chatty.api.domain")
@EnableMongoAuditing
class RepositoryConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "neoway-chatty-database";
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoClientURI connectionString =
                new MongoClientURI("mongodb://fabiano:fabiano@ds011923.mlab.com:11923/neoway-chatty-database");
        return new MongoClient(connectionString);
    }

}
