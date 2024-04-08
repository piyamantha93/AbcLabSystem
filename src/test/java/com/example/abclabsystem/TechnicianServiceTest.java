package com.example.abclabsystem;

import com.example.abclabsystem.dto.TechnicianDTO;
import com.example.abclabsystem.entity.Technician;
import com.example.abclabsystem.repos.TechnicianRepo;
import com.example.abclabsystem.service.TechnicianService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TechnicianServiceTest {

    @Mock
    private TechnicianRepo technicianRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private TechnicianService technicianService;

    @Test
    public void testGetAllTechnicians() {
        // Mock data
        Technician technician = new Technician();
        // Set technician properties

        TechnicianDTO technicianDTO = new TechnicianDTO();
        // Set technicianDTO properties

        // Mock the behavior of technicianRepo.findAll()
        when(technicianRepo.findAll()).thenReturn(Collections.singletonList(technician));

        // Mock the behavior of modelMapper.map()
        when(modelMapper.map(technician, TechnicianDTO.class)).thenReturn(technicianDTO);

        // Call the getAllTechnicians() method of the service
        List<TechnicianDTO> result = technicianService.getAllTechnicians();

        // Assert the result
        assertEquals(Collections.singletonList(technicianDTO), result);
    }

    @Test
    public void testAddTechnician() {
        // Mock data
        TechnicianDTO technicianDTO = new TechnicianDTO();
        // Set technicianDTO properties

        Technician technician = new Technician();
        // Set technician properties

        // Mock the behavior of modelMapper.map()
        when(modelMapper.map(technicianDTO, Technician.class)).thenReturn(technician);

        // Mock the behavior of technicianRepo.save()
        when(technicianRepo.save(technician)).thenReturn(technician);

        // Call the addTechnician() method of the service
        TechnicianDTO result = technicianService.addTechnician(technicianDTO);

           }


}
