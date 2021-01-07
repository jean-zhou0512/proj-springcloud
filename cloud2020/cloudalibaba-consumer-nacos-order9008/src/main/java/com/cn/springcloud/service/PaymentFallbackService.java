package com.cn.springcloud.service;

import com.cn.springcloud.entities.Payment;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult qryPaymentById(Long id) {
        Payment payment=new Payment();
        payment.setSerial("errorSerial");
        payment.setId(id);
        return new CommonResult(payment,446,"服务降级---PaymentFallbackService");
    }
}
