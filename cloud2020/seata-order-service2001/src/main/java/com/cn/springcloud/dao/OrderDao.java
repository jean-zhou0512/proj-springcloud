package com.cn.springcloud.dao;

import com.cn.springcloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
    void createOrder(Order order);

    int updateOrder(Long userId,int status);
}
