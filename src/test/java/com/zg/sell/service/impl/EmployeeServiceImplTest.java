package com.zg.sell.service.impl;

import com.zg.sell.domain.Employee;
import com.zg.sell.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;
    @Test
    public void findAgeTest(){
        Employee employee = employeeService.getOne(2);
        Assert.notNull(employee, "对象为空错误");
    }
}