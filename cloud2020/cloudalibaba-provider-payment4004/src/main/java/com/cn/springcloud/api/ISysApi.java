package com.cn.springcloud.api;

import com.cn.springcloud.entities.Payment;

public interface ISysApi {
    public Payment qryPaymentById(Long id);
}
