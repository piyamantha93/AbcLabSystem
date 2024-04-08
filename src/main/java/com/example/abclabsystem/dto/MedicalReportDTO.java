package com.example.abclabsystem.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class MedicalReportDTO {



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
    private byte[] pdfContent;;

    // Constructors
    public MedicalReportDTO(Long patientId, String s, Date date, byte[] pdfContent) {
    }

    public MedicalReportDTO(Long patientId, Date reportDate, byte[] pdfContent) {
        this.patientId = patientId;
        this.reportDate = reportDate;
        this.pdfContent = pdfContent;
    }

    public MedicalReportDTO() {

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

    public byte[] getPdfContent() {return pdfContent;}

    public void setpdfContent(byte[] getPdfContent) {this.pdfContent = pdfContent;}


    public void setReportDate(String date) {
    }
}
