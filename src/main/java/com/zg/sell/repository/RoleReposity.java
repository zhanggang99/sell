package com.zg.sell.repository;

import com.zg.sell.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleReposity extends JpaRepository<Role,String> {
}
