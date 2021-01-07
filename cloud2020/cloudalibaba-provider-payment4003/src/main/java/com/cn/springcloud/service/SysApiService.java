package com.cn.springcloud.service;

import com.cn.springcloud.api.ISysApi;
import com.cn.springcloud.dao.PaymentDao;
import com.cn.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysApiService implements ISysApi {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public Payment qryPaymentById(Long id) {
        return paymentDao.qryPaymentById(id);
    }
}
