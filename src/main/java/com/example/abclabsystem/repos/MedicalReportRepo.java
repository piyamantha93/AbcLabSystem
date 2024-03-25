package com.example.abclabsystem.repos;

import com.example.abclabsystem.dto.MedicalReportDTO;
import com.example.abclabsystem.entity.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface MedicalReportRepo extends JpaRepository<MedicalReport ,Long> {
    MedicalReport findBypatientId(Long patientId);

    List<MedicalReport> findAllByPatientId(Long patientId);
}
