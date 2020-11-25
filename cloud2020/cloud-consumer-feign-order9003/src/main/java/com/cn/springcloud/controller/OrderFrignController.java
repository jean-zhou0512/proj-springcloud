package com.cn.springcloud.controller;


import com.cn.springcloud.service.PaymentService;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFrignController {

    @Resource
    private PaymentService paymentService;


    @RequestMapping(value="/service/consumerFeign/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentService.qryPaymentById(id);
    }

    @RequestMapping(value="/service/consumerFeign/paymentPort")
    public String paymentPort(){
        return paymentService.paymentPort();
    }


    @RequestMapping(value="/service/consumerFeign/timeout")
    public String timeout(){
        return paymentService.timeout();
    }
}
