package com.cn.springcloud.api;

import com.cn.springcloud.entities.Payment;

public interface SysApi {
    public int createPayment(Payment payment);

    public Payment qryPaymentById(Long id);
}
