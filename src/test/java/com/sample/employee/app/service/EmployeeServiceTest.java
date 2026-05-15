package com.sample.employee.app.service;

import com.sample.employee.app.model.EmployeeModel;
import com.sample.employee.app.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest{
    public static EmployeeModel emp = new EmployeeModel();
    @Mock
    private EmployeeRepository repo;
    @InjectMocks
    private EmployeeServiceImpl service;
    @BeforeAll
    static void initiate(){
        emp.setName("h");
        emp.setEmail("h@gmail.com");
        emp.setDepartment("H");
    }
    @Test
    void testCreateEmployee(){
        when(repo.save(emp)).thenReturn(emp);
        EmployeeModel savedEmp = service.create(emp);
        assertNotNull(savedEmp);
        assertEquals("h",savedEmp.getName());
        assertEquals("H",savedEmp.getDepartment());
    }
}
