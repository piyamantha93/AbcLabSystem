package com.example.abclabsystem.controller;

import com.example.abclabsystem.dto.TechnicianDTO;
import com.example.abclabsystem.entity.Technician;
import com.example.abclabsystem.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnicianController {

    private final TechnicianService technicianService;

    @Autowired
    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @PostMapping("/technicianLogin")
    public ResponseEntity<TechnicianDTO> technicianLogin(@RequestParam String username, @RequestParam String password) {
        Technician technician = technicianService.login(username, password);
        if (technician != null) {
            TechnicianDTO technicianDTO = convertToDTO(technician);
            return new ResponseEntity<>(technicianDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    private TechnicianDTO convertToDTO(Technician technician) {
        TechnicianDTO technicianDTO = new TechnicianDTO();
        technicianDTO.setId(technician.getId());
        technicianDTO.setName(technician.getName());
        technicianDTO.setUsername(technician.getUsername());
        // Don't include password for security reasons
        return technicianDTO;
    }
}

