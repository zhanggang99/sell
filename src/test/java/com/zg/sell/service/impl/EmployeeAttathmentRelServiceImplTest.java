package com.zg.sell.service.impl;

import com.zg.sell.domain.EmployeeAttachmentRel;
import com.zg.sell.service.EmployeeAttathmentRelService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EmployeeAttathmentRelServiceImplTest {
    @Resource
    private EmployeeAttathmentRelService employeeAttathmentRelService;

    @Test
    public void testMongoDB(){
        EmployeeAttachmentRel employeeAttachmentRel= new EmployeeAttachmentRel("1","1","aa.txt");
        employeeAttathmentRelService.save(employeeAttachmentRel);
        System.out.println("保存成功！");
    }

}