package com.example.abclabsystem.controller;

import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.entity.Technician;
import com.example.abclabsystem.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TechnicianController {

    private TechnicianService technicianService;

    @PostMapping("/technicianLogin")
    public ResponseEntity<Technician> technicianLogin(@RequestParam String username, @RequestParam String password) {
        Technician technician = technicianService.login(username, password);
        if (technician != null) {
            return new ResponseEntity<>(technician, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
