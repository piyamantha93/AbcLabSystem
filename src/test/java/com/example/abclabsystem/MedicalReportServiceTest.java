package com.example.abclabsystem;

import com.example.abclabsystem.dto.MedicalReportDTO;
import com.example.abclabsystem.entity.MedicalReport;
import com.example.abclabsystem.repos.MedicalReportRepo;
import com.example.abclabsystem.service.MedicalReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicalReportServiceTest {

    @Mock
    private MedicalReportRepo medicalReportRepo;

    @InjectMocks
    private MedicalReportService medicalReportService;

    @Test
    public void testSaveReport() throws Exception {
        // Mock data
        MedicalReportDTO medicalReportDTO = new MedicalReportDTO();
        medicalReportDTO.setPatientId(1L);
        medicalReportDTO.setReportDate("2022-02-22");
        // Set other properties as needed

        byte[] pdfContent = "PDF content".getBytes(); // Mock PDF content
        MockMultipartFile file = new MockMultipartFile("file", "test.pdf", "application/pdf", pdfContent);

        MedicalReport medicalReport = new MedicalReport();
        // Set medicalReport properties

        // Mock the behavior of medicalReportRepo.save()
        when(medicalReportRepo.save(any(MedicalReport.class))).thenReturn(medicalReport);

        // Call the saveReport() method of the service
        MedicalReport result = medicalReportService.saveReport(medicalReportDTO, file);

        // Verify that medicalReportRepo.save() was called once with the correct argument
        verify(medicalReportRepo, times(1)).save(any(MedicalReport.class));

        // Assert the result
        assertEquals(medicalReport, result);
    }

    @Test
    public void testFindAllByPatientId() {
        // Mock data
        Long patientId = 1L;
        MedicalReport medicalReport = new MedicalReport();
        // Set medicalReport properties

        // Mock the behavior of medicalReportRepo.findAllByPatientId()
        when(medicalReportRepo.findAllByPatientId(patientId)).thenReturn(Collections.singletonList(medicalReport));

        // Call the findAllByPatientId() method of the service
        List<MedicalReport> result = medicalReportService.findAllByPatientId(patientId);

        // Assert the result
        assertEquals(Collections.singletonList(medicalReport), result);
    }
}

