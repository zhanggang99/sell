package com.zg.sell.listener;

import com.zg.sell.domain.User;
import com.zg.sell.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class UserListener implements ServletContextListener {

    Logger logger= LogManager.getLogger(this.getClass());

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserService userService;
    private static final String ALL_USER="ALL_USER_LIST";
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //System.out.println("上下文初始化");
        logger.info("log:上下文初始化");
        //查询数据库所有有用户
        List<User> userList = userService.findAll();
        //清空缓存中用户数据
        redisTemplate.delete(ALL_USER);
        //将数据放到redis缓存中
        redisTemplate.opsForList().leftPushAll(ALL_USER,userList);

        //测试：
        List<User> queryUserList = redisTemplate.opsForList().range(ALL_USER,0,-1);
        //System.out.println("缓存中的用户数有："+queryUserList.size()+"人");
        logger.info("缓存中的用户数有："+queryUserList.size()+"人");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("log:上下文销毁");

    }
}
