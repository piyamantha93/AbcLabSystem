package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.AdminDTO;
import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.repos.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AdminService {



      @Autowired
      private AdminRepo adminRepo;

      public Admin registerAdmin(AdminDTO adminDTO) {

         // Convert DTO to entity
         Admin admin = new Admin();
         admin.setFullName(adminDTO.getFullName());
         admin.setGender(adminDTO.getGender());
         admin.setBirthday(adminDTO.getBirthday());
         admin.setUsername(adminDTO.getUsername());
         admin.setPassword(adminDTO.getPassword());

         // Save admin
         return adminRepo.save(admin);
      }

      public Admin login(String username, String password) {
         Admin admin = adminRepo.findByUsernameAndPassword(username ,password);
         if (admin != null && admin.getPassword().equals(password)) {
            return admin;
         }
         return null; // Invalid credentials
      }
   }


