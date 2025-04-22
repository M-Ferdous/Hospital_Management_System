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
    public ResponseEntity<Object> getAllPatientInfo() {
        List<PatientInfoDto> allPatientInfos = this.patientInfoService.getAllPatientInfo();
        return new ResponseEntity<Object>(allPatientInfos, HttpStatus.OK);
    }

    @GetMapping("/getAllFromSecondaryDb")
    public ResponseEntity<Object> getAllPatientInfoFromSecondaryDb() {
        List<PatientInfoDto> allPatientInfos = this.patientInfoService.getAllPatientInfoFromSecondaryDb();
        return new ResponseEntity<Object>(allPatientInfos, HttpStatus.OK);
    }

    //-----------------------------------------------------------------------

    @PutMapping("update/{id}")
    public ResponseEntity<String> updatePatientInfo(
            @PathVariable Long id,
            @RequestBody PatientInfoDto dto
    ) {
        boolean updated = patientInfoService.updatePatientInfo(id, dto);
        if (updated) {
            return ResponseEntity.ok("Patient info updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
        }
    }


    //------------------------------------------------------------------------by me-----------
   /* @PutMapping("/updated/{id}")
    public ResponseEntity<String> updatePaitent(@PathVariable("id") Long id, @RequestBody PatientInfoDto patientInfoDto) {

        patientInfoDto.setPatientId(id);

        return patientInfoService.getAllPatientInfoForUpdating(id, patientInfoDto);
    }*/

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePatientInfo(@PathVariable Long id) {
        boolean deleted = patientInfoService.deletePatientInfo(id);
        if (deleted) {
            return ResponseEntity.ok("Patient info deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
        }
    }



}
