package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.AdminDTO;
import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.repos.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class AdminAuthenticationService extends AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public Admin login(String username, String password) {
        return adminRepo.findByUsernameAndPassword(username, password);
    }


}
