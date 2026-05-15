package com.sample.employee.app.service;

import com.sample.employee.app.model.EmployeeModel;
import com.sample.employee.app.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository repo;
    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }
    @Override
    public EmployeeModel create(EmployeeModel employee){
        return repo.save(employee);
    }
    @Override
    public EmployeeModel getById(Long id){
          return repo.findById(id).orElseThrow();
    }
    @Override
    public List<EmployeeModel> getAll(){
        return repo.findAll();
    }
    @Override
    public void delete(long id){
        repo.deleteById(id);
    }
    @Override
    public EmployeeModel update(Long id,EmployeeModel employee){
        EmployeeModel emp = repo.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        emp.setName(employee.getName());
        emp.setDepartment(employee.getDepartment());
        emp.setEmail(employee.getEmail());
        return repo.save(emp);
    }
    @Override
    public List<EmployeeModel> getAlLSorted() {
         return repo.findAll(Sort.by("department"));
    }

}

