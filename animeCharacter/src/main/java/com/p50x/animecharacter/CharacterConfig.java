package com.p50x.animecharacter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CharacterConfig {

@Bean
public RestTemplate restTemplate(){
    return new RestTemplate();
}

}
