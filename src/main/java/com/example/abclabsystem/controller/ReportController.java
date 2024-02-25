package com.example.abclabsystem.controller;


import com.example.abclabsystem.dto.ReportDTO;
import com.example.abclabsystem.dto.ResponseDTO;
import com.example.abclabsystem.service.ReportService;
import com.example.abclabsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping (value = "/saveReport")
    public ResponseEntity saveReport(@RequestBody ReportDTO reportDTO){

        try{
            String res = reportService.saveReport(reportDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(reportDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already added");
                responseDTO.setContent(reportDTO);
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

    @GetMapping("/getAllReports")
    public ResponseEntity getAllReports() {

        try {
            List<ReportDTO> reportDTOList = reportService.getAllReports();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            System.out.println(reportDTOList);
            responseDTO.setContent(reportDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        } catch (Exception exception) {

            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
