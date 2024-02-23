package com.example.abclabsystem.entity;



import javax.persistence.*;


@Entity
@Table(name ="appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private long appointment_id;
    @Column(name = "patient_id", length = 20)
    private String patient_id;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "email", length = 20)
    private String email;
    @Column(name = "test", length = 20)
    private String test;
    @Column(name = "time", length = 20)
    private String time;
    @Column(name = "date", length = 20)
    private String date;

    public Appointment() {
    }

    public Appointment(long appointment_id, String patient_id, String name, String email, String test, String time, String date) {
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.name = name;
        this.email = email;
        this.test = test;
        this.time = time;
        this.date = date;
    }

    public long getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(long appointment_id) {
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
}
