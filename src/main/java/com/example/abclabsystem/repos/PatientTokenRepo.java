package com.example.abclabsystem.repos;

import com.example.abclabsystem.entity.AuthenticationTokenPatient;
import com.example.abclabsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientTokenRepo extends JpaRepository<AuthenticationTokenPatient, Integer> {
    AuthenticationTokenPatient findTokenByPatient(Optional<Patient> patient);

    AuthenticationTokenPatient findTokenByPatientToken(String token);
}
