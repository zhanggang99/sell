package com.zg.sell.service.impl;

import com.zg.sell.domain.User;
import com.zg.sell.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@SpringBootTest
class UserServiceImplTest {

    Logger logger= LogManager.getLogger(this.getClass());
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void findById() {
        Long redisUserSize=0L;
        User user=userService.findById("4");
        redisUserSize= redisTemplate.opsForList().size("ALL_USER_LIST");
        System.out.println("目前缓存用户数："+redisUserSize);

        User userNo = userService.findById("5");
        System.out.println("name:"+userNo.getName());
        redisUserSize=redisTemplate.opsForList().size("ALL_USER_LIST");
        System.out.println("目前缓存用户数："+redisUserSize);

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
        User user = new User("44","aomo","60");
        Assert.notNull(userService.save(user),"保存成功");
    }

    @Test
    void delete() {
        userService.delete("5");
        logger.info("删除用户成功");
    }

//    @Test
//    void testFindAll() {
//        Sort.Order idOrder = new Sort.Order(Sort.Direction.ASC,"id");
//        Sort.Order nameOrder = new Sort.Order(Sort.Direction.DESC,"name");
//        //Sort.Direction direction = new Sort.Direction();
//        Sort sort=new Sort(idOrder,nameOrder);
//        Pageable pageable = new PageRequest(0,1,idOrder);
//        Page<User> findAll =null;
//        List<User> content=null;
//        while (pageable!=null){
//            findAll=userService.findAll(pageable);
//            content=findAll.getContent();
//            System.out.println("content:"+content);
//            pageable=findAll.nextPageable();
//        }
//    }

    @Test
    void testFindAllSort(){
        Sort.Order idOrder = new Sort.Order(Sort.Direction.DESC, "id");
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(idOrder);
        Sort sort = Sort.by(Sort.Order.desc("id"));
        Pageable pageable=PageRequest.of(0,2,sort);
        Page<User> users = userService.findAll(pageable);
        users.forEach(user -> {
            System.out.println("1111:"+user.toString());
        });
    }

    @Test
    void testFindAll() {
        PageRequest pageRequest = PageRequest.of(0,10);
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

    @Test
    void testMybatis(){
        User user = userService.findByNameAndPassword("zt","222");
        logger.info(user.getId()+user.getName()+"找到了");
    }
    //测试三次同步调用的耗时
    @Test
    public void testAsync(){
        long start = System.currentTimeMillis();
        userService.findAll();
        userService.findAll();
        userService.findAll();
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start)+"毫秒");
    }

    //测试三次异步调用的耗时
    @Test
    public void testAsync2() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<List<User>> userlist = userService.findAsynAll();
        Future<List<User>> userlist2 = userService.findAsynAll();
        Future<List<User>> userlist3 = userService.findAsynAll();
        while (true){
            if (userlist.isDone() && userlist2.isDone() && userlist3.isDone())
                break;
            else
                Thread.sleep(10);
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start)+"毫秒");

    }
}