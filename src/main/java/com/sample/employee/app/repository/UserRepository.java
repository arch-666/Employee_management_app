package com.sample.employee.app.repository;

import com.sample.employee.app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {
    public UserModel findByUsername(String username);
}
