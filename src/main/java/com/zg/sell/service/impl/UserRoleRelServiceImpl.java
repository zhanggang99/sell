package com.zg.sell.service.impl;

import com.zg.sell.domain.UserRoleRel;
import com.zg.sell.repository.UserRoleRelRepository;
import com.zg.sell.service.UserRoleRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleRelServiceImpl implements UserRoleRelService {
    @Autowired
    private UserRoleRelRepository userRoleRelReposity;
    @Override
    public List<UserRoleRel> findByUserId(String userId) {
        return userRoleRelReposity.findByUserId(userId);
    }
}
