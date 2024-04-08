package com.example.abclabsystem;

import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.repos.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientRepoTests {

    @Mock
    private PatientRepository patientRepository;

    @Test
    public void testFindByUsernameAndPassword() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";
        Patient patient = new Patient();
        patient.setUsername(username);
        patient.setPassword(password);

        // Mock the behavior of PatientRepository.findByUsernameAndPassword
        when(patientRepository.findByUsernameAndPassword(username, password)).thenReturn(patient);

        // Act
        Patient foundPatient = patientRepository.findByUsernameAndPassword(username, password);

        // Assert
        assertEquals(patient, foundPatient);

        // Verify that findByUsernameAndPassword was called exactly once with the specified arguments
        verify(patientRepository, times(1)).findByUsernameAndPassword(username, password);
    }
}


