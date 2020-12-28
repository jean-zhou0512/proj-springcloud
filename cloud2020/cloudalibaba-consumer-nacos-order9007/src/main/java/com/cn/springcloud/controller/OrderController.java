package com.cn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/service/comsumer/getPayment/{id}")
    public String getPaymentId(@PathVariable Long id){
        return restTemplate.getForObject(url+"/service/payment/"+id,String.class);
    }
}
