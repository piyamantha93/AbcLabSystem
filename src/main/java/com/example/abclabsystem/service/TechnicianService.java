package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.TechnicianDTO;
import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.entity.Technician;
import com.example.abclabsystem.repos.TechnicianRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TechnicianService {

    private final ModelMapper modelMapper;

    @Autowired
    public TechnicianService(@Qualifier("technicianRepo") TechnicianRepo technicianRepo, ModelMapper modelMapper) {
        this.technicianRepo = technicianRepo;
        this.modelMapper = modelMapper;
    }

    public List<TechnicianDTO> getAllTechnicians() {
        List<Technician> technicians = technicianRepo.findAll();
        return technicians.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TechnicianDTO addTechnician(TechnicianDTO technicianDTO) {
        Technician technician = convertToEntity(technicianDTO);
        Technician savedTechnician = technicianRepo.save(technician);
        return convertToDTO(savedTechnician);
    }

    public TechnicianDTO updateTechnician(Long id, TechnicianDTO technicianDTO) {
        Optional<Technician> optionalTechnician = technicianRepo.findById(id);
        if (optionalTechnician.isPresent()) {
            Technician technician = optionalTechnician.get();
            technician.setName(technicianDTO.getName());
            technician.setUsername(technicianDTO.getUsername());
            technician.setPassword(technicianDTO.getPassword());
            Technician updatedTechnician = technicianRepo.save(technician);
            return convertToDTO(updatedTechnician);
        } else {
            // Handle technician not found
            return null;
        }
    }

    public void deleteTechnician(Long id) {
        technicianRepo.deleteById(id);
    }

    private TechnicianDTO convertToDTO(Technician technician) {
        return modelMapper.map(technician, TechnicianDTO.class);
    }

    private Technician convertToEntity(TechnicianDTO technicianDTO) {
        return modelMapper.map(technicianDTO, Technician.class);
    }

    @Autowired
    private TechnicianRepo technicianRepo;

    public Technician registerTechnician(TechnicianDTO technicianDTO) {
        // Convert TechnicianDTO to Technician entity
        Technician technician = new Technician();
        technician.setName(technicianDTO.getName());
        technician.setUsername(technicianDTO.getUsername());
        technician.setPassword(technicianDTO.getPassword());

        // Save technician to database
        return technicianRepo.save(technician);
    }

    public Technician login(String username, String password) {
        return technicianRepo.findByUsernameAndPassword(username, password);
    }

}

