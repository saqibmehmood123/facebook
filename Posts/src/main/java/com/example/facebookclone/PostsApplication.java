package com.example.facebookclone;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.boot.SpringApplication;
@SpringBootApplication
@EnableDiscoveryClient
public class PostsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostsApplication.class, args);
    }


}