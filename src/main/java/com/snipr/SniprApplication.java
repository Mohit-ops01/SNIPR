package com.snipr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SniprApplication {

    public static void main(String[] args) {
        SpringApplication.run(SniprApplication.class, args);
        System.out.println("\n==============================================");
        System.out.println("🚀 SNIPR Application Started Successfully!");
        System.out.println("📍 Access at: http://localhost:8080");
        System.out.println("==============================================\n");
    }
}