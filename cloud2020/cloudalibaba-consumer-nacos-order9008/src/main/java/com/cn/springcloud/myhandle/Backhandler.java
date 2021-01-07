package com.cn.springcloud.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cn.springcloud.entities.Payment;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

public class Backhandler {

    public static CommonResult handleFallBack(@RequestParam(value = "id",required =  true)Long id, Throwable e){
        Payment payment = new Payment();
        payment.setId(0L);
        payment.setSerial("");
        return new CommonResult(payment,444,"handleFallBack 错误信息:"+e.getMessage());
    }

    public static CommonResult handleBlockBack(@RequestParam(value = "id",required=true)Long id, BlockException exception){
        return new CommonResult(445,"handleBlockBack sentinel限流...");
    }
}
