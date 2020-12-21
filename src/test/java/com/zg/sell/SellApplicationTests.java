package com.zg.sell;

import com.zg.sell.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SellApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("name","zhanggang");
        String name =(String)redisTemplate.opsForValue().get("name");
        System.out.println("redis name:"+name);
        //删除
        //redisTemplate.delete("name");
        //修改
        redisTemplate.opsForValue().set("name","newzhanggnag");
        name =(String)redisTemplate.opsForValue().get("name");
        System.out.println("redis name:"+name);

        List<User> userList = new ArrayList<>();
        System.out.println(userList.getClass().getName());

    }

}
