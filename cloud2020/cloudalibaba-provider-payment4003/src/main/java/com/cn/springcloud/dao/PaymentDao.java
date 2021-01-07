package com.cn.springcloud.dao;

import com.cn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public Payment qryPaymentById(Long id);
}
