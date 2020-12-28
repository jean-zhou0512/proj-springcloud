package com.cn.sringcloud.service;

import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping(value="/service/qryPaymentById/{id}")
    public CommonResult qryPaymentById(@PathVariable("id")Long id);

    @GetMapping(value="/service/payment/zipkin")
    public String paymentZipkin();
}
