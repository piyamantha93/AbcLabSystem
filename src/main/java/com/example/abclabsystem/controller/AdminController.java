package com.example.abclabsystem.controller;

import com.example.abclabsystem.dto.AdminDTO;
import com.example.abclabsystem.dto.ResponseDTO;
import com.example.abclabsystem.dto.TechnicianDTO;
import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private TechnicianService technicianService;

    @Autowired
    private AdminService adminService;

    // Get all technicians
    @GetMapping("/technicians")
    public ResponseEntity<List<TechnicianDTO>> getAllTechnicians() {
        List<TechnicianDTO> technicians = technicianService.getAllTechnicians();
        return new ResponseEntity<>(technicians, HttpStatus.OK);
    }

    // Add a new technician
    @PostMapping("/technicians")
    public ResponseEntity<TechnicianDTO> addTechnician(@RequestBody TechnicianDTO technicianDTO) {
        TechnicianDTO newTechnician = technicianService.addTechnician(technicianDTO);
        return new ResponseEntity<>(newTechnician, HttpStatus.CREATED);
    }

    // Update an existing technician
    @PutMapping("/technicians/{id}")
    public ResponseEntity<TechnicianDTO> updateTechnician(@PathVariable long id, @RequestBody TechnicianDTO technicianDTO) {
        TechnicianDTO updatedTechnician = technicianService.updateTechnician(id, technicianDTO);
        return new ResponseEntity<>(updatedTechnician, HttpStatus.OK);
    }

    // Delete a technician
    @DeleteMapping("/technicians/{id}")
    public ResponseEntity<Void> deleteTechnician(@PathVariable long id) {
        technicianService.deleteTechnician(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody AdminDTO adminDTO) {
        Admin registeredAdmin = adminService.registerAdmin(adminDTO);
        return new ResponseEntity<>(registeredAdmin, HttpStatus.CREATED);
    }

    @PostMapping("/adminLogin")
    public ResponseEntity<Admin> adminLogin(@RequestParam String username, @RequestParam String password) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


}








