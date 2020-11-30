package com.cn.springcloud.controller;

import com.cn.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value="/service/hystrixOk/{id}")
    public String hystrixOk(@PathVariable("id")int id){
        return paymentHystrixService.hystrix_ok(id);
    }

    @GetMapping(value="/service/hystrixTimeout/{id}")
    public String hystrixTimeout(@PathVariable("id") int id){
        return paymentHystrixService.hystrix_timeout(id);
    }

    @GetMapping(value="/service/hystrixCircuitBreaker/{id}")
    public String hystrixCircuitBreaker(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentCircuitBreaker(id);
    }
}
