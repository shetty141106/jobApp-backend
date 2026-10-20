package com.example.jobApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "The username can't be empty")
    private String username;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "The password cannot be empty")
    private String password;

    private String role;
}