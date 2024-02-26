package com.example.abclabsystem.dto;

public class AppointmentDTO {
    private String appointment_id;
    private String patient_id;
    private String name;
    private String email;
    private String test;
    private String time;
    private String date;

    public AppointmentDTO() {
    }

//    public AppointmentDTO(String appointment_id, String patient_id, String name, String email, String test, String time, String date) {
//        this.appointment_id = appointment_id;
//        this.patient_id = patient_id;
//        this.name = name;
//        this.email = email;
//        this.test = test;
//        this.time = time;
//        this.date = date;
//    }

    public AppointmentDTO(long appointmentId, String patientId, String name, String email, String test, String time, String date) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "appointment_id='" + appointment_id + '\'' +
                ", patient_id='" + patient_id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", test='" + test + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
