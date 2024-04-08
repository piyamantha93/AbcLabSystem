package com.example.abclabsystem;

import com.example.abclabsystem.dto.PatientDTO;
import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.repos.PatientRepository;
import com.example.abclabsystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    public void testRegisterPatient() {
        // Create a patient DTO
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFullName("John Doe");
        patientDTO.setEmail("john@example.com");
        // Set other properties as needed

        // Mock the behavior of the patientRepository.save() method
        Patient patient = new Patient();
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        // Call the registerPatient() method of the service
        Patient result = patientService.registerPatient(patientDTO);

        // Verify that the save() method of patientRepository was called once with the correct argument
        verify(patientRepository, times(1)).save(any(Patient.class));

        // Assert that the result is not null
        assertEquals(patient, result);
    }

    @Test
    public void testLogin() {
        // Create a sample patient
        Patient patient = new Patient();
        patient.setUsername("john");
        patient.setPassword("password");
        // Set other properties as needed

        // Mock the behavior of the patientRepository.findByUsernameAndPassword() method
        when(patientRepository.findByUsernameAndPassword("john", "password")).thenReturn(patient);

        // Call the login() method of the service
        Patient result = patientService.login("john", "password");

        // Verify that the findByUsernameAndPassword() method of patientRepository was called once with the correct arguments
        verify(patientRepository, times(1)).findByUsernameAndPassword("john", "password");

        // Assert that the result is not null
        assertEquals(patient, result);
    }
}
