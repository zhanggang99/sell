package com.zg.sell.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
public class EmployeeAttachmentRel {
    @Id
    private String id;
    private String userId;
    private String fileName;

}
