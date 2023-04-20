package com.example.springbootdemo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootDemo4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo4Application.class, args);
    }

}
