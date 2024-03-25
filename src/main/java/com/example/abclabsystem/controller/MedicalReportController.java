package com.example.abclabsystem.controller;

import com.example.abclabsystem.dto.MedicalReportDTO;
import com.example.abclabsystem.entity.MedicalReport;
import com.example.abclabsystem.service.MedicalReportService;
import com.example.abclabsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.Date;

@RestController
@RequestMapping("/medicalReports")

public final class MedicalReportController {

    @Autowired
    private MedicalReportService medicalReportService;
    private PatientService patientService;

    @PostMapping("/upload")
    public ResponseEntity<MedicalReport> uploadMedicalReport(
            @RequestParam("patientId") Long patientId,
            @RequestParam("reportDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date reportDate, // Correctly applying @DateTimeFormat
            @RequestParam("file") MultipartFile file) {
        try {

            MedicalReportDTO medicalReportDTO = new MedicalReportDTO();
            medicalReportDTO.setPatientId(patientId);
            medicalReportDTO.setReportDate(reportDate);
            MedicalReport savedReport = medicalReportService.saveReport(medicalReportDTO, file);

                       return ResponseEntity.ok(savedReport);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
        @Autowired
        public MedicalReportController(MedicalReportService medicalReportService) {
            this.medicalReportService = medicalReportService;
        }

        @GetMapping("/{patientId}/reports")
        public ResponseEntity<List<MedicalReport>> getReportsByPatientId(@PathVariable("patientId") Long patientId) {
            try {
                List<MedicalReport> reports = medicalReportService.findAllByPatientId(patientId);
                if(reports.isEmpty()) {
                    return ResponseEntity.noContent().build();
                }
                return ResponseEntity.ok(reports);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(null);
            }
        }

}




