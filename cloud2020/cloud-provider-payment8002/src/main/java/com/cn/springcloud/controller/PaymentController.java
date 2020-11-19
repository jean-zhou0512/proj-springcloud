package com.cn.springcloud.controller;

import com.cn.springcloud.api.SysApi;
import com.cn.springcloud.entities.Payment;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private SysApi sysApi;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/service/createPayment")
    public CommonResult createPayment(HttpServletRequest request){
        String serial = request.getParameter("serial");
        Payment payment = new Payment();
        payment.setSerial(serial);
        int result = sysApi.createPayment(payment);
        if (result > 0 ){
            return new CommonResult(result,"success serverPort:"+port);
        }else{
            return  new CommonResult(result,"error");
        }
    }

    @RequestMapping(value="/service/qryPaymentById")
    public CommonResult qryPaymentById(HttpServletRequest request){
        String id = request.getParameter("id");
        Payment payment = sysApi.qryPaymentById(Long.parseLong(id));
        if(payment  != null){
            return new CommonResult(payment,200,"success serverPort: "+port);
        }else{
            return new CommonResult(null,400,"error");
        }
    }

    @RequestMapping(value="/service/getDiscovery")
    public Object getDiscovery(){
        List<String> services=discoveryClient.getServices();

        for(String service : services){
            System.out.println("*******"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

}
