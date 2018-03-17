package com.neoway.chatty.api;

import com.neoway.chatty.api.web.MessageController;
import com.neoway.chatty.api.web.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages ={"com.neoway.chatty.api.service", "com.neoway.chatty.api.config"})
@SpringBootApplication
public class AppInitializer {

    public static void main(String[] args) {
        Object[] configurations = new Object[] {
                AppInitializer.class,
                UserController.class,
                MessageController.class
        };
        SpringApplication.run(configurations, args);
    }


}
