package com.cn.springcoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWayMain5001 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain5001.class,args);
    }
}
