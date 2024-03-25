package com.example.abclabsystem.dto;

import javax.persistence.*;

public class AppointmentDTO {


    private String patientId;

    private String name;

    private String email;

    private String testType;

    private String date;

    // Default constructor
    public AppointmentDTO() {
    }
    // Constructor with parameters
    public AppointmentDTO(String patientId, String name, String email, String testType, String date) {
        this.patientId = patientId;
        this.name = name;
        this.email = email;
        this.testType = testType;
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
