package com.zg.sell.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.zg.sell.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
