package com.cn.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface AccountService {
    @RequestMapping(value = "/service/account/decreaseMoney")
    public void decreaseMoney(@RequestParam("userId") Long userId, @RequestParam("money") double money);
}
