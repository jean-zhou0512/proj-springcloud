package com.cn.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @RequestMapping(value="/service/payment/port")
    public String paymentPort();

    @RequestMapping(value="/service/feign/timeout")
    public String timeout();
}
