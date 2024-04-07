package com.example.abclabsystem.repos;

import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.entity.Appointment;
import com.example.abclabsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface AdminRepo extends JpaRepository<Admin, Long> {
        Admin findByUsernameAndPassword(String username, String password);


    }

