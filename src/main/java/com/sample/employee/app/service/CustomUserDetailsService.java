package com.sample.employee.app.service;

import com.sample.employee.app.model.EmployeeModel;
import com.sample.employee.app.model.UserModel;
import com.sample.employee.app.repository.EmployeeRepository;
import com.sample.employee.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel emp = repo.findByUsername(username);
        if(emp == null){
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder().username(emp.getUsername()).password(emp.getPassword()).roles(emp.getRole()).build();
    }
}


