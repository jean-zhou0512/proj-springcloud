package com.cn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain9004 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain9004.class,args);
    }
}
