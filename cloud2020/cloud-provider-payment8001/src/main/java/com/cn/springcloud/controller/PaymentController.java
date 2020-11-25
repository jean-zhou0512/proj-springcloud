package com.cn.springcloud.controller;

import com.cn.springcloud.api.SysApi;
import com.cn.springcloud.entities.Payment;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @RequestMapping(value="/service/payment/port")
    public String paymentPort(){
        return port;
    }

    @RequestMapping(value="/service/feign/timeout")
    public String timeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return port;
    }
}
