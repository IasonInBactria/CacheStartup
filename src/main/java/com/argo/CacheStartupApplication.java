package com.argo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheStartupApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheStartupApplication.class, args);
    }

}
