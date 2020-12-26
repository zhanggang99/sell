package com.zg.sell.service;

import com.zg.sell.domain.Employee;

public interface EmployeeService {
    //public Integer getAge(Integer id);
    public void getAge(Integer id) throws Exception;
    public Employee getOne(Integer id);

}
