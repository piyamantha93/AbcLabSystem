package com.example.abclabsystem;

import com.example.abclabsystem.entity.Report;
import com.example.abclabsystem.repos.ReportRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportRepoTests {

    @Mock
    private ReportRepo reportRepo;

    @Test
    public void testFindByDate() {
        // Arrange
        String date = "2024-04-08";
        Report report = new Report();
        report.setDate(date);

        // Mock the behavior of ReportRepo.findByDate
        when(reportRepo.findByDate(date)).thenReturn(report);

        // Act
        Report foundReport = reportRepo.findByDate(date);

        // Assert
        assertEquals(report, foundReport);

        // Verify that findByDate was called exactly once with the specified argument
        verify(reportRepo, times(1)).findByDate(date);
    }
}
