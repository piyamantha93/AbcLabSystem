package com.example.abclabsystem.controller;

import com.example.abclabsystem.dto.ResponseDTO;
import com.example.abclabsystem.entity.MedicalReport;
import com.example.abclabsystem.service.AppointmentService;
import com.example.abclabsystem.service.MedicalReportService;
import com.example.abclabsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
public class AdminController {

    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicalReportService medicalReportService;



    // View appointments list

    // Accept or Reject Appointment

    // Upload Medical Report

    // View Patient Profile
    @GetMapping("/patients/{patientId}")
    public String viewPatientProfile(@PathVariable Long patientId) {
        return patientService.findById(patientId);
    }


}
