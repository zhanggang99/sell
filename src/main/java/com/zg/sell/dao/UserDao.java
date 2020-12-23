package com.zg.sell.dao;

import com.zg.sell.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    User findByNameAndPassword(@Param("name") String name,@Param("password") String password);
}
