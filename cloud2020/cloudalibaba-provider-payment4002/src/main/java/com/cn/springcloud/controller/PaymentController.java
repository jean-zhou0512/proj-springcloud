package com.cn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/service/payment/{id}")
    public String getPaymentId(@PathVariable Long id){
        return "nacos register serverPort: "+serverPort + " id= "+id;
    }
}
