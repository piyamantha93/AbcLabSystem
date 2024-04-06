package com.example.abclabsystem.controller;

import com.example.abclabsystem.dto.ResponseDTO;
import com.example.abclabsystem.service.AppointmentService;
import com.example.abclabsystem.service.MedicalReportService;
import com.example.abclabsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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





}




