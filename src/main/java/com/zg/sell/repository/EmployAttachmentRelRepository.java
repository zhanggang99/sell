package com.zg.sell.repository;

import com.zg.sell.domain.EmployeeAttachmentRel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployAttachmentRelRepository extends MongoRepository<EmployeeAttachmentRel,String> {
}
