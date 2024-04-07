package com.example.abclabsystem.repos;

import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepo extends JpaRepository<Technician, Long> {
    Technician findByUsernameAndPassword(String username, String password);
}


