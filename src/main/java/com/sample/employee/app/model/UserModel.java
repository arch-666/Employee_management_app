package com.sample.employee.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name="users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private  String password;
    private String role;
}
