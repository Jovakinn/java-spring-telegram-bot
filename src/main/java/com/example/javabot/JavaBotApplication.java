package com.example.javabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class JavaBotApplication {
    private static final Logger logger = Logger.getLogger(JavaBotApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(JavaBotApplication.class, args);
        logger.info("Application is started!");
    }
}
