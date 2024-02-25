package com.example.abclabsystem.entity;

import javax.persistence.*;


@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fName", length = 30,nullable = false)
    private String fName;
    @Column(name = "gender", length = 30,nullable = false)
    private String gender;
    @Column(name = "email", length = 30,nullable = false)
    private String email;
    @Column(name = "password", length = 30,nullable = false)
    private String password;

    public Patient() {
    }

    public Patient(long id, String fName, String gender, String email, String encryptedpassword) {
        this.id = id;
        this.fName = fName;
        this.gender = gender;
        this.email = email;
        this.password = encryptedpassword;
    }

    public Patient(String s, String gender, String email, String encryptedPassword) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
}
