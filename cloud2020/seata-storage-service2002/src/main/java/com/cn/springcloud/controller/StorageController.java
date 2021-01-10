package com.cn.springcloud.controller;

import com.cn.springcloud.api.IStorageApi;
import com.cn.springcloud.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private IStorageApi storageApi;

    @RequestMapping(value="/service/storage/decreaseStorage")
    public CommonResult decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") int count){
        storageApi.decreaseStorage(productId,count);
        return new CommonResult(200,"扣减库存成功！");

    }
}
