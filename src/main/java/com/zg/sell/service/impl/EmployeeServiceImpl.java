package com.zg.sell.service.impl;

import com.zg.sell.domain.Employee;
import com.zg.sell.domain.Result;
import com.zg.sell.enums.ResultEnum;
import com.zg.sell.exception.EmployeeException;
import com.zg.sell.repository.EmployeeRepository;
import com.zg.sell.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

//    @Override
//    public Integer getAge(Integer id){
//        com.zg.sell.domain.Employee employee = employeeRepository.findById(id).orElse(null);
//        Integer age = employee.getAge();
//        //实现方式：返回int做判断，但特别别扭。
//        if (age<=13)
//            return 1;
//        else if(age>13 && age<18)
//            return 2;
//        return 0;
//    }

    //改进：通过统一异常处理来反馈
    @Override
    public void getAge(Integer id) throws Exception{
        com.zg.sell.domain.Employee employee = employeeRepository.findById(id).orElse(null);
        Integer age = employee.getAge();
        //实现方式：返回int做判断，但特别别扭。
        if (age<=13)
            //throw new EmployeeException(100,"小于13");
            throw  new EmployeeException(ResultEnum.ERROR);
        else if(age>13 && age<18)
            //throw new EmployeeException(101,"小于18");
            throw  new EmployeeException(ResultEnum.ERROR);
    }

    @Override
    public Employee getOne(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
