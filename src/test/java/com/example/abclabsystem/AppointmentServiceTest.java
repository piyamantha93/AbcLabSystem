package com.example.abclabsystem;

import com.example.abclabsystem.dto.AppointmentDTO;
import com.example.abclabsystem.entity.Appointment;
import com.example.abclabsystem.repos.AppointmentRepo;
import com.example.abclabsystem.service.AppointmentService;
import com.example.abclabsystem.util.VarList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private AppointmentRepo appointmentRepo;

    @InjectMocks
    private AppointmentService appointmentService;

    @Test
    public void testSaveAppointment_Success() {
        // Mock data
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setDate("2022-02-22");
        // Set other properties as needed

        Appointment appointmentEntity = new Appointment();
        // Set appointmentEntity properties

        // Mock the behavior of appointmentRepo.findByDate()
        when(appointmentRepo.findByDate(appointmentDTO.getDate())).thenReturn(null);

        // Mock the behavior of modelMapper.map()
        when(modelMapper.map(appointmentDTO, Appointment.class)).thenReturn(appointmentEntity);

        // Call the saveAppointment() method of the service
        String result = appointmentService.saveAppointment(appointmentDTO);

        // Verify that appointmentRepo.save() was called once
        verify(appointmentRepo, times(1)).save(appointmentEntity);

        // Assert the result
        assertEquals(VarList.RSP_SUCCESS, result);
    }

    @Test
    public void testSaveAppointment_Duplicated() {
        // Mock data
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setDate("2022-02-22");
        // Set other properties as needed

        Appointment existingAppointment = new Appointment();
        // Set existingAppointment properties

        // Mock the behavior of appointmentRepo.findByDate()
        when(appointmentRepo.findByDate(appointmentDTO.getDate())).thenReturn(existingAppointment);

        // Call the saveAppointment() method of the service
        String result = appointmentService.saveAppointment(appointmentDTO);

        // Verify that appointmentRepo.save() was not called
        verify(appointmentRepo, never()).save(any(Appointment.class));

        // Assert the result
        assertEquals(VarList.RSP_DUPLICATED, result);
    }

    // Add more test methods for other functionalities as needed
}

