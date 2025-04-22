package com.hospitalAPI.hospitalManagementSystem.controller;


import com.hospitalAPI.hospitalManagementSystem.DTO.PatientInfoDto;
import com.hospitalAPI.hospitalManagementSystem.service.Interfaces.LimsService;
import com.hospitalAPI.hospitalManagementSystem.service.Interfaces.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class patientInfoController {

    @Autowired
    private PatientInfoService patientInfoService;




    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllPatientInfo(){
        List<PatientInfoDto> allPatientInfos = this.patientInfoService.getAllPatientInfo();
        return new ResponseEntity<Object>(allPatientInfos, HttpStatus.OK);
    }

    @GetMapping("/getAllFromSecondaryDb")
    public ResponseEntity<Object> getAllPatientInfoFromSecondaryDb(){
        List<PatientInfoDto> allPatientInfos = this.patientInfoService.getAllPatientInfoFromSecondaryDb();
        return new ResponseEntity<Object>(allPatientInfos, HttpStatus.OK);
    }


    @PutMapping("/updated")
    public ResponseEntity<String> updatePaitent(@RequestBody PatientInfoDto patientInfoDto) {
        return this.patientInfoService.getAllPatientInfoForUpdating(patientInfoDto);
    }





}
