package com.example.employee_wellness_tracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Entity representing a user in the system.
* A user can be an Employee or an Admin.
*/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;
    private String phone;
    private String department;
    private String password;
    private boolean active = true;
    
    // Role of the user (EMPLOYEE or ADMIN)
    @Enumerated(EnumType.STRING)
    private Role role;
}
