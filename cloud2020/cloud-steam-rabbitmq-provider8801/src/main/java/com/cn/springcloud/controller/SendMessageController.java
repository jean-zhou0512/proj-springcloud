package com.cn.springcloud.controller;

import com.cn.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @RequestMapping(value = "/service/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
