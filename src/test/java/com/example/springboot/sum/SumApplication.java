package com.example.springboot.sum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
class SumApplication {
    public static void main(String[] args) {
        SpringApplication.run(SumApplication.class, args);
    }
}