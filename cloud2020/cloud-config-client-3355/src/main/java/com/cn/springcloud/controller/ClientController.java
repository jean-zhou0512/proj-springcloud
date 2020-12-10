package com.cn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {

    @Value("${spring.cloud}")
    private String data;

    @RequestMapping("/service/client/getData")
    public String getData(){
        return data;
    }
}
