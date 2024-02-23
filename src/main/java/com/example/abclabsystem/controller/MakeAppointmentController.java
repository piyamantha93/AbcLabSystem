package com.example.abclabsystem.controller;


import com.example.abclabsystem.dto.AppointmentDTO;
import com.example.abclabsystem.dto.ResponseDTO;
import com.example.abclabsystem.service.AppointmentService;
import com.example.abclabsystem.util.VarList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointment")

public class MakeAppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping (value = "/saveAppointment")
    public ResponseEntity saveAppointment(@RequestBody AppointmentDTO appointmentDTO){

        try{
            String res = appointmentService.saveAppointment(appointmentDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(appointmentDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already added");
                responseDTO.setContent(appointmentDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
            else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception exception){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
