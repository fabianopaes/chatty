package com.neoway.chatty.api;

import com.neoway.chatty.api.web.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages ="com.neoway.chatty.api.service")
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.neoway.chatty.api.domain")
public class AppInitializer {

    public static void main(String[] args) {
        Object[] configurations = new Object[] {
                AppInitializer.class,
                UserController.class
        };
        SpringApplication.run(configurations, args);
    }


}
