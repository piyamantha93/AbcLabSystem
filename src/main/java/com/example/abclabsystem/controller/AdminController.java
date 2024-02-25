package com.example.abclabsystem.controller;

import com.example.abclabsystem.dto.AdminDTO;
import com.example.abclabsystem.dto.ResponseDTO;
import com.example.abclabsystem.util.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class AdminController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/Adminpanel")
    public String adminPage(){
        return "adminpanel";
    }



}
