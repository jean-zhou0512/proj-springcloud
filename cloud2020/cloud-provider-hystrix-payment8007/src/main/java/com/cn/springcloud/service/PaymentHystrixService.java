package com.cn.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentHystrixService {

    public String hystrix_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id;
    }

    public String hystrix_timeout(Integer id){
        int time=5;
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_timeout,id: "+id+"耗时(秒):"+time;
    }
}
