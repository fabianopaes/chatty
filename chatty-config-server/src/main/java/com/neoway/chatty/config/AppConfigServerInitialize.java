package com.neoway.chatty.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class AppConfigServerInitialize {

	public static void main(String[] args) {
		SpringApplication.run(AppConfigServerInitialize.class, args);
	}
}