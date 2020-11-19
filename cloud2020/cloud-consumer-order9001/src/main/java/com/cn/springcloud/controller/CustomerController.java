package com.cn.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    static final String url="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/service/payment")
    public String payment(){
        String result = restTemplate.getForObject(url+"/payment/zk",String.class);
        return result;
    }
}
