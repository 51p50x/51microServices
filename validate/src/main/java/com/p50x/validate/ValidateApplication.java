package com.p50x.validate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ValidateApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValidateApplication.class,args);
    }
}
