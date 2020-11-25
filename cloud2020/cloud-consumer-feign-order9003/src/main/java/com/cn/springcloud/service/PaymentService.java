package com.cn.springcloud.service;

import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @RequestMapping(value="/service/qryPaymentById/{id}")
    public CommonResult qryPaymentById(@PathVariable("id") Long id);


    @RequestMapping(value="/service/payment/port")
    public String paymentPort();


    @RequestMapping(value="/service/feign/timeout")
    public String timeout();
}
