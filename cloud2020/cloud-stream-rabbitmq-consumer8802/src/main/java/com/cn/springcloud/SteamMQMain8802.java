package com.cn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SteamMQMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(SteamMQMain8802.class,args);
    }
}
