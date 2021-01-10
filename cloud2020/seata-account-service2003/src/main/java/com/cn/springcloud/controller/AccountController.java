package com.cn.springcloud.controller;

import com.cn.springcloud.api.IAccountApi;
import com.cn.springcloud.utils.result.CommonResult;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private IAccountApi accountApi;

    @RequestMapping(value = "/service/account/decreaseMoney")
    public CommonResult decreaseMoney(@RequestParam("userId") Long userId, @RequestParam("money") double money){
        accountApi.decreaseMoney(userId,money);
        return new CommonResult(200,"订单扣除余额成功");
    }
}
