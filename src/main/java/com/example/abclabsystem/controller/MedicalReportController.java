package com.example.abclabsystem.controller;

import com.example.abclabsystem.dto.MedicalReportDTO;
import com.example.abclabsystem.entity.MedicalReport;
import com.example.abclabsystem.service.MedicalReportService;
import com.example.abclabsystem.service.PatientProfile;
import com.example.abclabsystem.service.PatientService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/medicalReports")
public final class MedicalReportController {

    @Autowired
    private MedicalReportService medicalReportService;
    private PatientService patientService;


    @PostMapping("/upload")
    public ResponseEntity<MedicalReport> uploadMedicalReport(
            @RequestParam("patientId") Long patientId,
            @RequestParam("reportDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date reportDate, // Correctly applying @DateTimeFormat
            @RequestParam("file") MultipartFile file) {
        try {
            // Create a MedicalReportDTO from the provided information
            MedicalReportDTO medicalReportDTO = new MedicalReportDTO();
            medicalReportDTO.setPatientId(patientId);
            medicalReportDTO.setReportDate(reportDate); // You might need to parse the string to a Date object based on your DTO definition
            // medicalReportDTO.setPdfContent() is not set here, since it's handled inside the service

            // Call the service to save the report and the file
            MedicalReport savedReport = medicalReportService.saveReport(medicalReportDTO, file);

            // Return the saved report and HTTP status
            return ResponseEntity.ok(savedReport);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }




}




