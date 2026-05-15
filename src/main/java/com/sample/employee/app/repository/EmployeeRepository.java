package com.sample.employee.app.repository;

import com.sample.employee.app.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {
    EmployeeModel findByName(String name);
}
