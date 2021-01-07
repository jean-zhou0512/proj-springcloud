package com.cn.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cn.springcloud.myhandle.Backhandler;
import com.cn.springcloud.service.PaymentService;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Value("${server-url.provider-service}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/service/consumer/qryPaymentById")
//    @SentinelResource(value="consumerfallBack")
//    @SentinelResource(value="consumerfallBack",fallback = "handleFallBack")
//    @SentinelResource(value="consumerblockBack",blockHandler = "handleBlockBack")
//    @SentinelResource(value = "consumerAllBack",fallback = "handleFallBack",blockHandler = "handleBlockBack")
    @SentinelResource(value = "consumerAllBack",fallbackClass = Backhandler.class,fallback = "handleFallBack",blockHandlerClass = Backhandler.class,blockHandler = "handleBlockBack",exceptionsToIgnore = {IllegalArgumentException.class})//exceptionsToIgnore忽略配置的错误,多个用逗号隔开
    public CommonResult qryPaymentById(
            @RequestParam(value = "id",required = true)Long id
    ){

        CommonResult result =restTemplate.getForObject(url+"/service/payment/qryPaymentById?id="+id,CommonResult.class);

        if(id > 100){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
       return result;
    }



    //-------openFeign
    @Resource
    private PaymentService paymentService;

    @RequestMapping("/service/consumerFeign/qryPaymentById2")
    @SentinelResource(value="consumerFeign",fallbackClass = Backhandler.class,fallback = "handleFallBack",blockHandlerClass = Backhandler.class,blockHandler = "handleBlockBack")
    public CommonResult qryPaymentById2(@RequestParam(value="id",required = true)Long id){

        CommonResult result = paymentService.qryPaymentById(id);
        if(id > 100){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

}
