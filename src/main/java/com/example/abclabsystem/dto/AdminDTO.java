package com.example.abclabsystem.dto;

public class AdminDTO {
    private long id;

    private String email;

    private String password;

    private String role;

    private String fName;

    public AdminDTO() {
    }

    public AdminDTO(long id, String email, String password, String gender, String fName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.fName = fName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String gender) {
        this.role = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
