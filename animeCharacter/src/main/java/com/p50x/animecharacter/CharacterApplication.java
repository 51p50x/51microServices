package com.p50x.animecharacter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.p50x.clients.validate"
)
public class CharacterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CharacterApplication.class, args);
    }
}
