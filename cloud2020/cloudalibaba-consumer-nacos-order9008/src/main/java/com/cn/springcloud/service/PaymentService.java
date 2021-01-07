package com.cn.springcloud.service;

import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider-payment-nacos",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @RequestMapping(value="/service/payment/qryPaymentById")
    public CommonResult qryPaymentById(@RequestParam(value = "id",required = true)Long id);
}
