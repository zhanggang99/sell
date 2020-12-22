package com.zg.sell.service.impl;

import com.zg.sell.domain.User;
import com.zg.sell.repository.UserRepository;
import com.zg.sell.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    private static final String ALL_USER="ALL_USER_LIST";
    @Resource
    private RedisTemplate redisTemplate;//启用redis缓存机制。
    @Override
    public User findById(String id) {

        //从redis查询，如果有则返回，没有则加入缓存后返回。
        List<User> userList=redisTemplate.opsForList().range(ALL_USER,0,-1);
        if (userList!=null && userList.size()>0){
            for (User user:userList){
                if (user.getId().equals(id)){
                    return user;
                }
            }
            //todo 优化。
//            userList.stream().filter(user -> {
//                user.getId()==id;
//            }).findFirst();
        }
        User user=userRepository.findById(id).orElse(null);
        if (user!=null){
            redisTemplate.opsForList().leftPush(ALL_USER,user);
        }
        return user;
        //return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        User u = userRepository.save(user);
        //抛出异常，回滚
        //String str = null;
        //str.split("/");
        return u;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByNameLike(String name) {
        return userRepository.findByNameLike(name);
    }

    @Override
    public List<User> findByIdIn(Collection<String> ids) {
        return userRepository.findByIdIn(ids);
    }

}
