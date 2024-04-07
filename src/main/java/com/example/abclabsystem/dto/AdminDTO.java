package com.example.abclabsystem.dto;

public class AdminDTO {
    private String fullName;
    private String gender;
    private String birthday;
    private String username;
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String fullName, String gender, String birthday, String username, String password) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
