package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.MedicalReportDTO;
import com.example.abclabsystem.entity.MedicalReport;
import com.example.abclabsystem.repos.MedicalReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@Transactional

public class MedicalReportService {



    @Autowired
    private MedicalReportRepo medicalReportRepo;

    @DateTimeFormat
    @Lob

    // Method to save a new medical report with the PDF file
    public MedicalReport saveReport(MedicalReportDTO medicalReportDTO, MultipartFile file) {
        try {
            byte[] pdfContent = file.getBytes(); // Convert MultipartFile to byte[]
            MedicalReport medicalReport = new MedicalReport();
            medicalReport.setPatientId(medicalReportDTO.getPatientId());
            medicalReport.setPdfContent(pdfContent);
            medicalReport.setReportDate(medicalReportDTO.getReportDate());
            // Set the PDF content

            return medicalReportRepo.save(medicalReport); // Save to repository
        } catch (IOException e) {
            throw new RuntimeException("Failed to store PDF content", e);
        }
    }


    public List<MedicalReport> findAllByPatientId(Long patientId) {
        return medicalReportRepo.findAllByPatientId(patientId);
    }
}



