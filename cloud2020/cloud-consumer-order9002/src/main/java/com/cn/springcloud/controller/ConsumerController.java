package com.cn.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    public static String url = "http://consul-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/service/constomer/consul")
    public String ConstomerConsul(){
        String result = restTemplate.getForObject(url+"/service/payment/consul",String.class);
        return result;
    }
}
