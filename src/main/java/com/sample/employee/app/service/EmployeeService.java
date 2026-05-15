package com.sample.employee.app.service;

import com.sample.employee.app.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel create(EmployeeModel Employee);
    List<EmployeeModel> getAll();
     EmployeeModel getById(Long id);
    EmployeeModel update(Long id,EmployeeModel employee);
    List<EmployeeModel> getAlLSorted();
    void delete(long id);
}
