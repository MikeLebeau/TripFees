package com.magier.tripservice.infrastructure.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.magier.tripservice")
@SpringBootTest(classes = AppConfig.class)
public class AppConfig {
}