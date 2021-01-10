package com.cn.springcloud.service;

import com.cn.springcloud.api.IAccountApi;
import com.cn.springcloud.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AccountService implements IAccountApi {

    @Autowired
    private AccountDao accountDao;
    @Override
    public void decreaseMoney(Long userId, double money) {
        System.out.println("------->account-service中扣减账户余额开始");
       /* try{
            TimeUnit.SECONDS.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        accountDao.decreaseMoney(userId,money);
        System.out.println("------->account-service中扣减账户余额结束");
    }
}
