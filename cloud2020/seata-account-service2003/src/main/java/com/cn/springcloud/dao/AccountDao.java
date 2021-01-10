package com.cn.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {
    public void decreaseMoney(@Param("userId") Long userId, @Param("money") double money);
}
