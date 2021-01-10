package com.cn.springcloud.dao;

import com.cn.springcloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void createOrder(Order order);

    int updateOrder(@Param("userId") Long userId, @Param("status") Integer status);
}
