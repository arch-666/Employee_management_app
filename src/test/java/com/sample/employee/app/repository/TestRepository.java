package com.sample.employee.app.repository;

import com.sample.employee.app.model.EmployeeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRepository {
    private EmployeeModel emp;
    @Autowired
    public EmployeeRepository repo;
    @BeforeEach
    public void initialize(){
        emp = new EmployeeModel();
        emp.setId(1L);
        emp.setName("ram");
        emp.setEmail("ram@gmail.com");
        emp.setDepartment("IT");
    }
    @Test
    public void testRepo(){
        repo.save(emp);
        EmployeeModel saveEmployee = repo.findById(1L).orElseThrow();
        assertEquals(1L,saveEmployee.getId());
        assertEquals("ram",saveEmployee.getName());
        assertNotNull(saveEmployee.getId());
    }
    @Test
    public void testRepoUpdate(){
        EmployeeModel savedEmployee = repo.save(emp);
        savedEmployee.setName("changed");
        EmployeeModel changedEmployee = repo.save(savedEmployee);
        assertEquals("changed",changedEmployee.getName());

    }
    @Test
    public void testRepoDelete(){
        repo.save(emp);
        repo.deleteById(1L);
        Optional<EmployeeModel> employee = repo.findById(1L);
        assertFalse(employee.isPresent());
    }
}
