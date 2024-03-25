package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.PatientDTO;
import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(PatientDTO patientDTO) {
        // Convert PatientDTO to Patient entity
        Patient patient = new Patient();
        patient.setFullName(patientDTO.getFullName());
        patient.setEmail(patientDTO.getEmail());
        patient.setGender(patientDTO.getGender());
        patient.setNic(patientDTO.getNic());
        patient.setBirthday(patientDTO.getBirthday());
        patient.setHealthHistory(patientDTO.getHealthHistory());
        patient.setUsername(patientDTO.getUsername());
        patient.setPassword(patientDTO.getPassword());

        // Save patient to database
        return patientRepository.save(patient);
    }

    public Patient login(String username, String password) {
        return patientRepository.findByUsernameAndPassword(username, password);
    }
}
