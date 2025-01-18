package com.example.wordgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WordGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordGameApplication.class, args);
        System.out.println("CONNECTED");
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
