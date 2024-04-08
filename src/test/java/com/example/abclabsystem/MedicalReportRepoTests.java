package com.example.abclabsystem;

import com.example.abclabsystem.entity.MedicalReport;
import com.example.abclabsystem.repos.MedicalReportRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicalReportRepoTests {

    @Mock
    private MedicalReportRepo medicalReportRepo;

    @Test
    public void testFindBypatientId() {
        // Arrange
        Long patientId = 1L;
        MedicalReport medicalReport = new MedicalReport();
        medicalReport.setPatientId(patientId);

        // Mock the behavior of MedicalReportRepo.findBypatientId
        when(medicalReportRepo.findBypatientId(patientId)).thenReturn(medicalReport);

        // Act
        MedicalReport foundMedicalReport = medicalReportRepo.findBypatientId(patientId);

        // Assert
        assertEquals(medicalReport, foundMedicalReport);

        // Verify that findBypatientId was called exactly once with the specified argument
        verify(medicalReportRepo, times(1)).findBypatientId(patientId);
    }

    @Test
    public void testFindAllByPatientId() {
        // Arrange
        Long patientId = 1L;
        MedicalReport medicalReport1 = new MedicalReport();
        medicalReport1.setPatientId(patientId);
        MedicalReport medicalReport2 = new MedicalReport();
        medicalReport2.setPatientId(patientId);
        List<MedicalReport> medicalReports = new ArrayList<>();
        medicalReports.add(medicalReport1);
        medicalReports.add(medicalReport2);

        // Mock the behavior of MedicalReportRepo.findAllByPatientId
        when(medicalReportRepo.findAllByPatientId(patientId)).thenReturn(medicalReports);

        // Act
        List<MedicalReport> foundMedicalReports = medicalReportRepo.findAllByPatientId(patientId);

        // Assert
        assertEquals(medicalReports.size(), foundMedicalReports.size());
        for (int i = 0; i < medicalReports.size(); i++) {
            assertEquals(medicalReports.get(i), foundMedicalReports.get(i));
        }

        // Verify that findAllByPatientId was called exactly once with the specified argument
        verify(medicalReportRepo, times(1)).findAllByPatientId(patientId);
    }
}
