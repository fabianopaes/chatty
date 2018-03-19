package com.neoway.chatty.api.utils;

import com.neoway.chatty.api.config.EndpointConfig;

import java.net.URI;
import java.net.URISyntaxException;

public class URIPathBinder {
    
    public static URI resourceLocationBuilder(String id) throws URISyntaxException {
        return new URI(EndpointConfig.USERS_SINGLE_RESOURCE.replace("{id}",id));
    } 
}
