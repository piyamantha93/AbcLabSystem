package com.example.abclabsystem.dto;

public class PatientDTO {
    private String fullName;
    private String email;
    private String gender;
    private String nic;
    private String birthday;
    private String healthHistory;
    private String username;
    private String password;

    public PatientDTO() {
    }

    public PatientDTO(String fullName, String email, String gender, String nic, String birthday, String healthHistory, String username, String password) {
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.nic = nic;
        this.birthday = birthday;
        this.healthHistory = healthHistory;
        this.username = username;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public void setHealthHistory(String healthHistory) {
        this.healthHistory = healthHistory;
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

    @Override
    public String toString() {
        return "PatientDTO{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", nic='" + nic + '\'' +
                ", birthday='" + birthday + '\'' +
                ", healthHistory='" + healthHistory + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
