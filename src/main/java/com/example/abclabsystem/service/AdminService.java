package com.example.abclabsystem.service;

import com.example.abclabsystem.dto.AdminDTO;
import com.example.abclabsystem.dto.AppointmentDTO;
import com.example.abclabsystem.entity.Admin;
import com.example.abclabsystem.entity.Appointment;
import com.example.abclabsystem.repos.AppointmentRepo;
import com.example.abclabsystem.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AdminService {

   Admin save() {
      return null;
   }


   protected abstract Admin save(AdminDTO adminDTO);
}
