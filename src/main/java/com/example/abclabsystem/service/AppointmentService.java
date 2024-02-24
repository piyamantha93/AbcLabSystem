package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.AppointmentDTO;
import com.example.abclabsystem.entity.Appointment;
import com.example.abclabsystem.repos.AppointmentRepo;
import com.example.abclabsystem.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AppointmentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AppointmentRepo appointmentRepo;
    public String saveAppointment(AppointmentDTO  appointmentDTO) {
        try {
            Appointment appointmentEntity = modelMapper.map(appointmentDTO, Appointment.class);

            // Check for duplicates based on the time value

            Appointment existingAppointment = appointmentRepo.findByTimeAndDate( appointmentDTO.getTime(), appointmentDTO.getDate());

            if (existingAppointment != null) {
                return VarList.RSP_DUPLICATED;
            }

            // Save the appointmentEntity
            appointmentRepo.save(appointmentEntity);
            return VarList.RSP_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace(); // You can replace this with proper logging
            return VarList.RSP_ERROR;
        }

    }

    public List<AppointmentDTO> getAllAppointments() {

        List<Appointment> appointmentList = appointmentRepo.findAll();
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();

//        for (Appointment appointment : appointmentList) {
//            AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
//            UserDTO userDTO = modelMapper.map(appointment.getUser(), UserDTO.class);
//            appointmentDTO.setUserDTO(userDTO);
//            appointmentDTOList.add(appointmentDTO);
//        }

        return appointmentDTOList;
    }
}
