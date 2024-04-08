package com.example.abclabsystem;

import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.repos.AdminRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdminRepoTests {

    @Mock
    private AdminRepo adminRepo;

    @Test
    public void testFindByUsernameAndPassword() {
        // Arrange
        String username = "test_username";
        String password = "test_password";
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        // Mock the behavior of AdminRepo.findByUsernameAndPassword
        when(adminRepo.findByUsernameAndPassword(username, password)).thenReturn(admin);

        // Act
        Admin foundAdmin = adminRepo.findByUsernameAndPassword(username, password);

        // Assert
        assertEquals(admin, foundAdmin);

        // Verify that findByUsernameAndPassword was called exactly once with the specified arguments
        verify(adminRepo, times(1)).findByUsernameAndPassword(username, password);
    }
}
