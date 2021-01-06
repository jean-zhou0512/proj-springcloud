package com.cn.springclooud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cn.springcloud.entities.Payment;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cn.springclooud.myhandle.CustomerBlockHandler;

@RestController
public class RateLimitController {

    @RequestMapping(value="/service/rate/byResource")
    @SentinelResource(value = "byResource" , blockHandler = "handleException")
    public CommonResult byResource(){
        Payment payment = new Payment();
        payment.setId(2021L);
        payment.setSerial("serial001");
        return new CommonResult(payment,200,"按资源名称限流测试成功");
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @RequestMapping(value="/service/rate/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        Payment payment = new Payment();
        payment.setId(2021L);
        payment.setSerial("sreial002");
        return new CommonResult(payment,200,"按url限流测试成功");
    }

    @RequestMapping("/service/rate/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler" , blockHandlerClass = CustomerBlockHandler.class,blockHandler = "customerBlockHandler2")
    public CommonResult customerBlockHandler(){
        Payment payment = new Payment();
        payment.setId(2021L);
        payment.setSerial("sreial003");
        return new CommonResult(payment,200,"客户自定义");
    }
}
