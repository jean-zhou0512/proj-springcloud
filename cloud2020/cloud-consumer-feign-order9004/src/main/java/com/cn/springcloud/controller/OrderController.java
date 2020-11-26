package com.cn.springcloud.controller;

import com.cn.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value="/service/consumer/paymentPort")
    public String paymentPort(){
        return paymentService.paymentPort();
    }

    @RequestMapping(value="/service/consumer/timeout")
    public String timeout(){
        return paymentService.timeout();
    }
}
