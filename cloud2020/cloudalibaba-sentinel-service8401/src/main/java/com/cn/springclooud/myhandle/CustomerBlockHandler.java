package com.cn.springclooud.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cn.springcloud.utils.result.CommonResult;
import com.sun.deploy.security.BlockedException;

public class CustomerBlockHandler {
    public static CommonResult customerBlockHandler1(BlockException exception){
        return new CommonResult(4444,"客户自定义 CustomerBlockHandler1.....");
    }

    public static CommonResult customerBlockHandler2(BlockException exception){
        return new CommonResult(4444,"客户自定义 CustomerBlockHandler2.....");
    }
}
