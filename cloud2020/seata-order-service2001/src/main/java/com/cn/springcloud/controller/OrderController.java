package com.cn.springcloud.controller;

import com.cn.springcloud.entities.Order;
import com.cn.springcloud.service.OrderServiceImpl;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping(value = "/servcie/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
