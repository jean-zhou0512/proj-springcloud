package com.cn.springcloud.service;

import com.cn.springcloud.api.IStorageApi;
import com.cn.springcloud.dao.StorageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageApiService implements IStorageApi {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decreaseStorage(Long projectId,int count) {
        System.out.println("------->storage-service中扣减库存开始");
        storageDao.decreaseStorage(projectId,count);
        System.out.println("------->storage-service中扣减库存结束");
    }
}