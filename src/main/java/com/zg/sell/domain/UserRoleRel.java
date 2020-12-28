package com.zg.sell.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role_rel")
@Data
public class UserRoleRel {
    @Id
    private String userId;
    private String roleId;
}
