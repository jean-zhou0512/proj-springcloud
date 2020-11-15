package com.cn.springcloud.controller;

import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomerController {

    final static String url="http://localhost:8001/";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/service/customer/createPayment")
    public CommonResult createPayment(HttpServletRequest request){
        String serial = request.getParameter("serial");
        return restTemplate.getForObject(url+"service/createPayment?serial="+serial,CommonResult.class);
    }

    @RequestMapping(value="/service/customer/qryPaymentById")
    public CommonResult qryPaymentById(HttpServletRequest request){
        String id = request.getParameter("id");
        return restTemplate.getForObject(url+"/service/qryPaymentById?id="+id,CommonResult.class);
    }
}
