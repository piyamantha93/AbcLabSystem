package com.example.abclabsystem;

import com.example.abclabsystem.entity.Technician;
import com.example.abclabsystem.repos.TechnicianRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TechnicianRepoTests {

    @Mock
    private TechnicianRepo technicianRepo;

    @Test
    public void testFindByUsernameAndPassword() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";
        Technician technician = new Technician();
        technician.setUsername(username);
        technician.setPassword(password);

        // Mock the behavior of TechnicianRepo.findByUsernameAndPassword
        when(technicianRepo.findByUsernameAndPassword(username, password)).thenReturn(technician);

        // Act
        Technician foundTechnician = technicianRepo.findByUsernameAndPassword(username, password);

        // Assert
        assertEquals(technician, foundTechnician);

        // Verify that findByUsernameAndPassword was called exactly once with the specified arguments
        verify(technicianRepo, times(1)).findByUsernameAndPassword(username, password);
    }
}
