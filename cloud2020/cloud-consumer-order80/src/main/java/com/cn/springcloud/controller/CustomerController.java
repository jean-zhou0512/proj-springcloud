package com.cn.springcloud.controller;

import com.cn.springcloud.lb.LoadBalancer;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {

    final static String url="http://CLOUD-PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @RequestMapping(value="/service/customer/qryPaymentById2")
    public CommonResult qryPaymentById2(HttpServletRequest request){
        String id = request.getParameter("id");
        ResponseEntity<CommonResult>  result= restTemplate.getForEntity(url+"/service/qryPaymentById?id="+id, CommonResult.class);
        if(result.getStatusCode().is2xxSuccessful()){
            return result.getBody();
        }else{
            return  new CommonResult(400,"操作失败");
        }
    }

    @RequestMapping(value="/service/customer/paymentPort")
    public String paymentPort(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalancer.getServiceInstance(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/service/payment/port",String.class);
    }
}
