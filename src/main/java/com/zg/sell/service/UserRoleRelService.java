package com.zg.sell.service;

import com.zg.sell.domain.UserRoleRel;

import java.util.List;

public interface UserRoleRelService {
    List<UserRoleRel> findByUserId(String userId);
}
