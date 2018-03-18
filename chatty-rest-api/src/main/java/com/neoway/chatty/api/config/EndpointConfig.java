package com.neoway.chatty.api.config;

public interface EndpointConfig {

    String USERS_COLLECTION = "/users";
    String USERS_SINGLE_RESOURCE = "/users/{id}";

    String MESSAGES_COLLECTION = "/messages";
    String MESSAGES_SINGLE_RESOURCE = "/messages/{id}";
}
