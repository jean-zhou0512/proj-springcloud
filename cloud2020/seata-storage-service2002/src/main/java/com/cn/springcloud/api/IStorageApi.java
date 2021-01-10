package com.cn.springcloud.api;

public interface IStorageApi {
    public void decreaseStorage(Long projectId,int count);
}
