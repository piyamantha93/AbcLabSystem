package com.example.abclabsystem.service;


import com.example.abclabsystem.dto.ReportDTO;
import com.example.abclabsystem.entity.Report;
import com.example.abclabsystem.repos.ReportRepo;
import com.example.abclabsystem.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ReportService {
    @Autowired
    private ReportRepo reportRepo;
   @Autowired
   private ModelMapper modelMapper;
    public String saveReport(ReportDTO reportDTO) {
        try {
            Report reportEntity = modelMapper.map(reportDTO, Report.class);

            Report existingReport = reportRepo.findByDate( reportDTO.getDate());

            if (existingReport != null) {
                return VarList.RSP_DUPLICATED;
            }

            // Save the reportEntity
            reportRepo.save(reportEntity);
            return VarList.RSP_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace(); // You can replace this with proper logging
            return VarList.RSP_ERROR;
        }
    }

    public List<ReportDTO> getAllReports() {
        List<Report> reportList = reportRepo.findAll();
        List<ReportDTO> reportDTOList = new ArrayList<>();

//        for (Appointment appointment : appointmentList) {
//            AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
//            UserDTO userDTO = modelMapper.map(appointment.getUser(), UserDTO.class);
//            appointmentDTO.setUserDTO(userDTO);
//            appointmentDTOList.add(appointmentDTO);
//        }

        return reportDTOList;
    }
}
