package com.cn.springcloud.controller;

import com.cn.springcloud.api.SysApi;
import com.cn.springcloud.entities.Payment;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private SysApi sysApi;

    @RequestMapping(value="/service/createPayment")
    public CommonResult createPayment(HttpServletRequest request){
        String serial = request.getParameter("serial");
        Payment payment = new Payment();
        payment.setSerial(serial);
        int result = sysApi.createPayment(payment);
        if (result > 0 ){
            return new CommonResult(result,200,"success serverPort:"+port);
        }else{
            return  new CommonResult(result,"error");
        }
    }


    @GetMapping(value="/service/qryPaymentById/{id}")
    public CommonResult qryPaymentById(@PathVariable("id")Long id){
        Payment payment = sysApi.qryPaymentById(id);
        if(payment  != null){
            return new CommonResult(payment,200,"success serverPort: "+port);
        }else{
            return new CommonResult(null,400,"error");
        }
    }

    @GetMapping(value="/service/payment/zipkin")
    public String paymentZipkin(){
        return "paymentZipkin server fall back,welcome to blog";
    }
}
