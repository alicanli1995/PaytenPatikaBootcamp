package com.example.weekthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class WeekThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeekThreeApplication.class, args);
    }



}
