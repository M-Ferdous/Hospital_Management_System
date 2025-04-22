package com.hospitalAPI.hospitalManagementSystem.controller;

import com.hospitalAPI.hospitalManagementSystem.DTO.batchSetupDTO;
import com.hospitalAPI.hospitalManagementSystem.DTO.limsDTO;
import com.hospitalAPI.hospitalManagementSystem.service.Interfaces.LimsService;
import com.hospitalAPI.hospitalManagementSystem.service.Interfaces.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/patient")
public class Lims_Controller {


    @Autowired
    LimsService limsService;


    @GetMapping("/getFromLims")
    public ResponseEntity<Object> getFromLims(){
        List<limsDTO> Infos = this.limsService.getFromLims();
        return new ResponseEntity<Object>(Infos, HttpStatus.OK);
    }

    @GetMapping("/getFromBatchSetup")
    public ResponseEntity<Object> getFromBatchSetup(){
        List<batchSetupDTO> Infos = this.limsService.getFromBatchSetup();
        return new ResponseEntity<Object>(Infos, HttpStatus.OK);
    }
}
