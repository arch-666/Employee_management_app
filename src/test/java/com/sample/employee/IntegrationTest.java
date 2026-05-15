package com.sample.employee;

import com.sample.employee.app.model.EmployeeModel;
import com.sample.employee.app.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void testCreateAndGetEmployee() throws Exception{
        EmployeeModel emp = new EmployeeModel();
        emp.setId(1L);
        emp.setName("ram");
        emp.setEmail("ram@gmail.com");
        emp.setDepartment("IT");
        mockMvc.perform(post("/api/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(emp))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        mockMvc.perform(get("/api/1")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("ram")).andExpect(jsonPath("$.email").value("ram@gmail.com"));
    }
}
