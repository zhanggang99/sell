package com.zg.sell.service;

import com.zg.sell.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public interface UserService {
    User findById(String id);
    List<User> findAll();
    User save(User user);
    void delete(String id);

    Page<User> findAll(Pageable pageable);

    //自定义方法
    List<User> findByName(String name);
    List<User> findByNameLike(String name);
    List<User> findByIdIn(Collection<String> ids);

    //mybatis 方式
    User findByNameAndPassword(String name,String password);
    //异步查询
    Future<List<User>> findAsynAll();
}
