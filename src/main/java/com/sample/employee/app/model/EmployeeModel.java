package com.sample.employee.app.model;

import jakarta.persistence.*;
@Entity
@Table(name = "employees")
public class EmployeeModel {
    public EmployeeModel() {
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmployeeModel(Long id, String name, String email, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }
    @Override
    public String toString(){
        return "id"+id+" name"+name+" email"+email+" department"+department;
    }
    @Id
    private Long id;
     private String name;
     private String email;
     private String department;
}
