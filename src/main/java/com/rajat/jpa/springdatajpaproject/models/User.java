package com.rajat.jpa.springdatajpaproject.models;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int user_id;

    @Column
    private String username;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Transient
    private String confirmPassword;


    public User() {
    }

    public User(int user_id, String email, String password) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
