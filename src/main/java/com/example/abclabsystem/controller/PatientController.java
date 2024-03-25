package com.example.abclabsystem.controller;

import com.example.abclabsystem.dto.PatientDTO;
import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public Patient registerPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.registerPatient(patientDTO);
    }

    @PostMapping("/login")
    public Patient login(@RequestParam String username, @RequestParam String password) {
        return patientService.login(username, password);
    }
}
