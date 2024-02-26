package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.AppointmentDTO;
import com.example.abclabsystem.dto.AppointmentVerifyDTO;
import com.example.abclabsystem.dto.PatientDTO;
import com.example.abclabsystem.entity.Appointment;
import com.example.abclabsystem.repos.AppointmentRepo;
import com.example.abclabsystem.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

//    public List<AppointmentDTO> getAllAppointments() {
//
//        List<Appointment> appointmentList = appointmentRepo.findAll();
//        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
//        for (AppointmentDTO appointmentDTO : appointmentDTOList) {
//            System.out.println(appointmentDTO);
//        }
//
//
////        for (Appointment appointment : appointmentList) {
////            AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
////            UserDTO userDTO = modelMapper.map(appointment.getUser(), UserDTO.class);
////            appointmentDTO.setUserDTO(userDTO);
////            appointmentDTOList.add(appointmentDTO);
////        }
//
//        return appointmentDTOList;
//    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointmentList = appointmentRepo.findAll();
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();

        // Assuming you have a constructor in AppointmentDTO that takes an Appointment object
        // or a separate method to convert Appointment to AppointmentDTO
        for (Appointment appointment : appointmentList) {
            AppointmentDTO dto = new AppointmentDTO(
                    appointment.getAppointment_id(),
                    appointment.getPatient_id(),
                    appointment.getName(),
                    appointment.getEmail(),
                    appointment.getTest(),
                    appointment.getTime(),
                    appointment.getDate()
            );
            appointmentDTOList.add(dto);
        }


        // Now printing all the items in appointmentDTOList
        for (AppointmentDTO appointmentDTO : appointmentDTOList) {
            System.out.println(appointmentDTO);
        }

        return appointmentDTOList;
    }


    public List<Appointment> findAll() {
        List<Appointment> appointmentDTOList = null;
        return  appointmentDTOList;
    }

    public List<Appointment> updateStatus(Long appointmentId, Object o) {
        List<Appointment> appointmentDTOList = null;
        return  appointmentDTOList;

    }


    public void updateActivity(Long appointmentId, AppointmentVerifyDTO appointmentVerifyDTO) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + appointmentId));

//        if (appointmentVerifyDTO.isConfirm()) {
//            appointment.setActiveState(true);
//            emailService.sendConfirmationEmail(appointment.getUser().getEmail());
//        } else if (appointmentVerifyDTO.isNonConfirm()) {
//            appointmentRepo.delete(appointment);
//            emailService.sendCancellationEmail(appointment.getUser().getEmail());
//        }
    }
}
