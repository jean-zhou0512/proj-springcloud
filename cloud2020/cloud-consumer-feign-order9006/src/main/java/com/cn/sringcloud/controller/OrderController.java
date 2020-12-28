package com.cn.sringcloud.controller;

import com.cn.springcloud.utils.result.CommonResult;
import com.cn.sringcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value="/service/consumerFeign/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentService.qryPaymentById(id);
    }

    @GetMapping(value="/service/consumer/zipkin")
    public String paymentZipkin(){
        return paymentService.paymentZipkin();
    }
}
