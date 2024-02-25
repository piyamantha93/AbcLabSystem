package com.example.abclabsystem.dto;

public class ReportDTO {
    private String appointment_id;
    private String patient_id;
    private String name;
    private String test;
    private String test_result;
    private String lab_technician;
    private String recommended_doctor;
    private String date;

    public ReportDTO() {
    }

    public ReportDTO(long appointment_id, String patient_id, String name, String test, String test_result, String lab_technician, String recommended_doctor, String date) {
        this.appointment_id = String.valueOf(appointment_id);
        this.patient_id = patient_id;
        this.name = name;
        this.test = test;
        this.test_result = test_result;
        this.lab_technician = lab_technician;
        this.recommended_doctor = recommended_doctor;
        this.date = date;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest_result() {
        return test_result;
    }

    public void setTest_result(String test_result) {
        this.test_result = test_result;
    }

    public String getLab_technician() {
        return lab_technician;
    }

    public void setLab_technician(String lab_technician) {
        this.lab_technician = lab_technician;
    }

    public String getRecommended_doctor() {
        return recommended_doctor;
    }

    public void setRecommended_doctor(String recommended_doctor) {
        this.recommended_doctor = recommended_doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
