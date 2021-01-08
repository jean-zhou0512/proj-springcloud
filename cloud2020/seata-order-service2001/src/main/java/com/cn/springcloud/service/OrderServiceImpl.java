package com.cn.springcloud.service;

import com.cn.springcloud.api.IOrderApi;
import com.cn.springcloud.dao.OrderDao;
import com.cn.springcloud.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderApi {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    public void create(Order order) {
        //新建订单
        orderDao.createOrder(order);

        //扣减库存
        System.out.println("------>订单微服务开始调用库存，做扣减Count");
        storageService.decreaseStorage(order.getProductId(),order.getCount());

        System.out.println("------>订单微服务开始调用库存，做扣减Count end");

        //扣减账户
        System.out.println("------>订单微服务开始调用账户,做扣减Money");
        accountService.decreaseMoney(order.getUserId(),order.getMoney());

        System.out.println("------>订单微服务开始调用账户，做扣减Money end");

        //修改订单状态，从0到1代表已经完成
        System.out.println("------>修改订单状态开始");
        orderDao.updateOrder(order.getUserId(),0);
        System.out.println("------>修改订单状态结束");

        System.out.println("------>下订单结束");
    }
}
