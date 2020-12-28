package com.zg.sell.service.impl;

import com.zg.sell.domain.EmployeeAttachmentRel;
import com.zg.sell.repository.EmployAttachmentRelRepository;
import com.zg.sell.service.EmployeeAttathmentRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeAttathmentRelServiceImpl implements EmployeeAttathmentRelService {

    @Resource
    private EmployAttachmentRelRepository employAttachmentRelRepository;

    @Override
    public EmployeeAttachmentRel save(EmployeeAttachmentRel employAttachmentRel) {
        return employAttachmentRelRepository.save(employAttachmentRel);
    }
}
