package com.sample.employee.app.controller;
import com.sample.employee.app.model.EmployeeModel;
import com.sample.employee.app.service.EmployeeService;
import com.sample.employee.app.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
    @Autowired
    public EmployeeService service;
    @GetMapping("/{id}")
    public EmployeeModel get(@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employee){
        return service.create(employee);
    }
    @GetMapping("/all")
    public List<EmployeeModel> getAll(){
        return service.getAll();
    }
     @GetMapping("/all/sorted")
    public List<EmployeeModel> getAllSorted(){
        return service.getAlLSorted();
    }
    @PutMapping("/{id}")
    public EmployeeModel updateEmployee(@PathVariable long id,@RequestBody EmployeeModel employee){
        return service.update(id,employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable  Long id){
        service.delete(id);
    }
}

