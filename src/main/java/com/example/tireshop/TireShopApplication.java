package com.example.tireshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@EnableCaching
@EnableFeignClients
@SpringBootApplication
public class TireShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(TireShopApplication.class, args);
    }
}