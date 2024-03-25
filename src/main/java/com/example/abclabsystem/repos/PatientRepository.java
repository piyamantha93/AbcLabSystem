package com.example.abclabsystem.repos;

import com.example.abclabsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUsernameAndPassword(String username, String password);
}
