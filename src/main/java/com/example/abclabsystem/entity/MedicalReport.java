package com.example.abclabsystem.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medical_reports")
public class MedicalReport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "report_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @Lob
    @Column(name = "pdf_content", columnDefinition="LONGBLOB",length = 225)
    private byte[] pdfContent;

    // Constructors
    public MedicalReport(Long patientId, String s, Date date, byte[] pdfContent) {
    }

    public MedicalReport(Long patientId, Date reportDate, byte[] pdfContent) {
        this.patientId = patientId;
        this.reportDate = reportDate;
        this.pdfContent = pdfContent;
    }

    public MedicalReport() {

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public byte[] getPdfContent() {
        return pdfContent;
    }

    public void setPdfContent(byte[] pdfContent) {
        this.pdfContent = pdfContent;
    }

    // ToString, Equals, and HashCode methods
}