package com.sample.employee.app.controller;

import com.sample.employee.app.model.EmployeeModel;
import com.sample.employee.app.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private EmployeeService service;
    @Test
    void testEmployeeController() throws Exception{
        EmployeeModel emp = new EmployeeModel();
        emp.setId(1L);
        emp.setName("h");
        emp.setEmail("h@gmail.com");
        when(service.getById(1L)).thenReturn(emp);
        mockMvc.perform(get("/api/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("h"));

    }
}
