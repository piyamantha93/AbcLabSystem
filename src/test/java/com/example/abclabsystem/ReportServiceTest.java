package com.example.abclabsystem;

import com.example.abclabsystem.dto.ReportDTO;
import com.example.abclabsystem.entity.Report;
import com.example.abclabsystem.repos.ReportRepo;
import com.example.abclabsystem.service.ReportService;
import com.example.abclabsystem.util.VarList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    private ReportRepo reportRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ReportService reportService;

    @Test
    public void testSaveReport_Success() {
        // Mock data
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setDate("2022-02-22");
        // Set other properties as needed

        Report reportEntity = new Report();
        reportEntity.setDate(reportDTO.getDate());
        // Set other properties as needed

        // Mock the behavior of reportRepo.findByDate()
        when(reportRepo.findByDate(reportDTO.getDate())).thenReturn(null);

        // Mock the behavior of modelMapper.map()
        when(modelMapper.map(reportDTO, Report.class)).thenReturn(reportEntity);

        // Call the saveReport() method of the service
        String result = reportService.saveReport(reportDTO);

        // Verify that reportRepo.save() was called once
        verify(reportRepo, times(1)).save(reportEntity);

        // Assert the result
        assertEquals(VarList.RSP_SUCCESS, result);
    }

    @Test
    public void testSaveReport_Duplicated() {
        // Mock data
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setDate("2022-02-22");
        // Set other properties as needed

        Report existingReport = new Report();
        existingReport.setDate(reportDTO.getDate());
        // Set other properties as needed

        // Mock the behavior of reportRepo.findByDate()
        when(reportRepo.findByDate(reportDTO.getDate())).thenReturn(existingReport);

        // Call the saveReport() method of the service
        String result = reportService.saveReport(reportDTO);

        // Verify that reportRepo.save() was not called
        verify(reportRepo, never()).save(any(Report.class));

        // Assert the result
        assertEquals(VarList.RSP_DUPLICATED, result);
    }

    @Test
    public void testSaveReport_Error() {
        // Mock data
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setDate("2022-02-22");
        // Set other properties as needed

        // Mock the behavior of reportRepo.findByDate() to throw an exception
        when(reportRepo.findByDate(reportDTO.getDate())).thenThrow(RuntimeException.class);

        // Call the saveReport() method of the service
        String result = reportService.saveReport(reportDTO);

        // Assert the result
        assertEquals(VarList.RSP_ERROR, result);
    }

    @Test
    public void testGetAllReports() {
        // Mock data
        Report report = new Report();
        // Set report properties

        ReportDTO reportDTO = new ReportDTO();
        // Set reportDTO properties

        // Mock the behavior of reportRepo.findAll()
        List<Report> reportList = new ArrayList<>();
        reportList.add(report);
        when(reportRepo.findAll()).thenReturn(reportList);

        // Mock the behavior of modelMapper.map()
        when(modelMapper.map(report, ReportDTO.class)).thenReturn(reportDTO);

        // Call the getAllReports() method of the service
        List<ReportDTO> result = reportService.getAllReports();

        // Assert the result
        assertEquals(Collections.singletonList(reportDTO), result);
    }
}
