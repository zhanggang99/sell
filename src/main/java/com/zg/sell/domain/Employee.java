package com.zg.sell.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Min(value = 18,message = "小于18不可以")
    private Integer age;

    public Employee(String name, Integer age) {
        this.name=name;
        this.age=age;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
