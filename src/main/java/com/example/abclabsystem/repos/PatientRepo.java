package com.example.abclabsystem.repos;

import com.example.abclabsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    Patient findByEmail(String email);
}
