package com.zg.sell.repository;

import com.zg.sell.domain.UserRoleRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRelRepository extends JpaRepository<UserRoleRel,String> {
    List<UserRoleRel> findByUserId(@Param("userId") String userId);
}
