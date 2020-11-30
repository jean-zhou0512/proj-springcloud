package com.cn.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class PaymentHystrixService {

    public String hystrix_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id;
    }

    @HystrixCommand(fallbackMethod = "hystrix_timeout_handler",
    commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")})//3秒钟以内就是正常的业务逻辑
    public String hystrix_timeout(Integer id){
        int time=3;
        int i = 10/0;
        try{
//            TimeUnit.SECONDS.sleep(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_timeout,id: "+id+"耗时(秒):"+time;
    }

    public String hystrix_timeout_handler(Integer id){
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_timeout_handler,id: "+id+"熔断返回";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler",
    commandProperties = {
         @HystrixProperty(name = "circuitBreaker.enabled",value="true"),//是否开启断路器
         @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
         @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
         @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if(id < 0){
            throw new RuntimeException("-----id不能为负数");
        }else{
            String serialNumber = UUID.randomUUID().toString();
            return Thread.currentThread().getName()+"\t"+"调用成功"
                    +"流水号："+serialNumber;
        }
    }

    public String paymentCircuitBreakerHandler(@PathVariable("id") Integer id){
        return "---------id不能为负数,请稍后再试.id:"+id;
    }



}
