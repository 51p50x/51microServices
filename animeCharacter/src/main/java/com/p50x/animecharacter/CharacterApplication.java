package com.p50x.animecharacter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CharacterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CharacterApplication.class, args);
    }
}
