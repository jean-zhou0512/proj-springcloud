package com.cn.springcloud.service;

import com.cn.springcloud.api.SysApi;
import com.cn.springcloud.dao.PaymentDao;
import com.cn.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysApiImpl implements SysApi {

    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment qryPaymentById(Long id) {
        return paymentDao.qryPaymentById(id);
    }
}
