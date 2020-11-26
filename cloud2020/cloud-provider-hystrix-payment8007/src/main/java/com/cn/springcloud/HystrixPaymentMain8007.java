package com.cn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HystrixPaymentMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8007.class,args);
    }
}
