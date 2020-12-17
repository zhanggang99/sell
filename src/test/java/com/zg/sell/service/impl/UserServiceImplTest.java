package com.zg.sell.service.impl;

import com.zg.sell.domain.User;
import com.zg.sell.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.sound.midi.Soundbank;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    void findById() {

    }

    @Test
    void findAll() {
        List<User> list=userService.findAll();
        System.out.println("一共有多少用户："+list.size());
        list.forEach(user ->{
            System.out.println(user.toString());
        });
    }

    //保存或更新
    @Test
    void save() {
        User user = new User("4","miaomiao","6");
        Assert.notNull(userService.save(user),"保存成功");
    }

    @Test
    void delete() {
    }

    @Test
    void testFindAll() {
        //PageRequest pageRequest=new PageRequest(0,1,new Sort(Sort.Direction.ASC,"id"));
        PageRequest pageRequest = PageRequest.of(0,1);
        Page<User> userPage=userService.findAll(pageRequest);
        System.out.println("分页查询有数据几个："+userPage.getSize());
        userPage.forEach(user ->{
            System.out.println(user.toString());
        });
    }

    @Test
    void findByName() {
    }

    @Test
    void findByNameLike() {
    }

    @Test
    void findByIdIn() {
    }
}