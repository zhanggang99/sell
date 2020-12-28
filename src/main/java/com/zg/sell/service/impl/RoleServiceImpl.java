package com.zg.sell.service.impl;

import com.zg.sell.domain.Role;
import com.zg.sell.repository.RoleReposity;
import com.zg.sell.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleReposity roleReposity;

    @Override
    public Role find(String id) {
        return roleReposity.findById(id).orElse(null);
    }
}
