package com.example.abclabsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Technician {

    @Id
    private Long id;
    private String Name;

    private String username;
    private String password;



    public Technician() {
    }

    public Technician(Long id, String name, String username, String password) {
        this.id = id;
        Name = name;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}