package com.cn.springcloud.controller;

import com.cn.springcloud.api.ISysApi;
import com.cn.springcloud.entities.Payment;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private ISysApi sysApi;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/service/payment/qryPaymentById")
    public CommonResult qryPaymentById(
            @RequestParam(value = "id",required = true)Long id){
        Payment payment = sysApi.qryPaymentById(id);
        return new CommonResult(payment,200,"查找成功 id:"+id+"端口："+serverPort);
    }
}
