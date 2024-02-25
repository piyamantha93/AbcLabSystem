package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.AdminDTO;
import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.repos.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class AdiminServiceImp extends AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Admin save(AdminDTO adminDTO){
        Admin admin = new Admin(adminDTO.getEmail(),adminDTO.getPassword(),adminDTO.getRole(),adminDTO.getfName());
        return adminRepo.save(admin);
    }

}
