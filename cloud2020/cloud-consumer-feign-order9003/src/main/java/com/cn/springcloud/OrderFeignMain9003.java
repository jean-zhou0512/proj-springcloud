package com.cn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain9003.class,args);
    }
}
