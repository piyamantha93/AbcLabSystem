package com.example.abclabsystem.entity;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name ="tokens_patient" )
public class AuthenticationTokenPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column  (name = "patientToken", length = 70,nullable = false)
    private String patientToken;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne(targetEntity = Patient.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "patient_id")
    private Patient patient;

    public AuthenticationTokenPatient() {
    }
    public AuthenticationTokenPatient(Patient patient) {
        this.patient = patient;
        this.createdDate = new Date();
        this.patientToken = UUID.randomUUID().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientToken() {
        return patientToken;
    }

    public void setPatientToken(String patientToken) {
        this.patientToken = patientToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
