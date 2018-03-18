package com.neoway.chatty.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AppServiceDiscoveryServerInitialize {

    public static void main(String[] args) {
        SpringApplication.run(AppServiceDiscoveryServerInitialize.class, args);
    }
}