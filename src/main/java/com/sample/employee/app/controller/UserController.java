package com.sample.employee.app.controller;

import com.sample.employee.app.dto.RequestDto;
import com.sample.employee.app.model.UserModel;
import com.sample.employee.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/health-check")
    public String get(){
        return "ok";
    }
    @PostMapping("/register")
    public String register(@RequestBody RequestDto request){
        UserModel user = UserModel.builder().username(request.getUsername()).password(passwordEncoder.encode(request.getPassword())).role("USER").build();
        userRepository.save(user);
        return "user Saved";
    }
    @PostMapping("/login")
    public String login(@RequestBody RequestDto request){
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        if(auth.isAuthenticated()){
            return "login successful";
        }
        return "login failed";
    }
}
