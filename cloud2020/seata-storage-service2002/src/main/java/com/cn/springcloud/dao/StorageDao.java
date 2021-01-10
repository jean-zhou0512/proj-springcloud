package com.cn.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    public void decreaseStorage(@Param("productId") Long productId, @Param("count") Integer count);
}
