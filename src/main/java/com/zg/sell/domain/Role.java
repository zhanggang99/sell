package com.zg.sell.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    private String id;
    private String name;
}
