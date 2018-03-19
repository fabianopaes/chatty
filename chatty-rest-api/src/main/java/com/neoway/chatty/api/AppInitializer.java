package com.neoway.chatty.api;

import com.neoway.chatty.api.events.EventDispatcher;
import com.neoway.chatty.api.events.MessageSentEvent;
import com.neoway.chatty.api.events.handler.MessageSentEventHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableDiscoveryClient
public class AppInitializer {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AppInitializer.class, args);

        context.getBean(EventDispatcher.class)
                .registerHandler(MessageSentEvent.class, new MessageSentEventHandler());
    }

}
