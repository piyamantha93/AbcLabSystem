package com.example.abclabsystem.dto;

public class PatientDTO {
    private long id;
    private String fName;
    private String gender;
    private String email;
    private String password;

    public PatientDTO() {
    }

    public PatientDTO(long id, String fName, String gender, String email, String password) {
        this.id = id;
        this.fName = fName;
        this.gender = gender;
        this.email = email;
        this.password = password;
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
