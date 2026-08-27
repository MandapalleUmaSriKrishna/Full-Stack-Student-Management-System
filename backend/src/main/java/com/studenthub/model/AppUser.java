package com.studenthub.model;

import jakarta.persistence.*;

@Entity @Table(name="users")
public class AppUser {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(unique=true, nullable=false) private String email;
    @Column(nullable=false) private String password;
    @Column(nullable=false) private String role;
    public AppUser() {} public AppUser(String email,String password,String role){this.email=email;this.password=password;this.role=role;}
    public String getEmail(){return email;} public String getPassword(){return password;} public String getRole(){return role;}
}
