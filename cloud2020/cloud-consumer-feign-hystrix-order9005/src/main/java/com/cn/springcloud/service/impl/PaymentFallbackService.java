package com.cn.springcloud.service.impl;

import com.cn.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String hystrixOk(int id) {
        return "--PaymentFallbackService-- fall back-hystrixOk,熔断测试";
    }

    @Override
    public String hystrixTimeout(int id) {
        return "--PaymentFallbackService-- fall back-hystrixTimeout,熔断测试";
    }
}
