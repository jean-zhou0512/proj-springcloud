package com.cn.springcloud.service;

import com.cn.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value="CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value="/service/hystrixOk/{id}")
    public String hystrixOk(@PathVariable("id")int id);

    @GetMapping(value="/service/hystrixTimeout/{id}")
    public String hystrixTimeout(@PathVariable("id") int id);

}
