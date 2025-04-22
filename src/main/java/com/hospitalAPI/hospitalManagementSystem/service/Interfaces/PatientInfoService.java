package com.hospitalAPI.hospitalManagementSystem.service.Interfaces;


import com.hospitalAPI.hospitalManagementSystem.DTO.PatientInfoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientInfoService {


    List<PatientInfoDto> getAllPatientInfo();

    List<PatientInfoDto> getAllPatientInfoFromSecondaryDb();


    // ResponseEntity<String> getAllPatientInfoForUpdating(Long id ,PatientInfoDto patientInfoDto);

    boolean updatePatientInfo(Long id, PatientInfoDto dto);

    boolean deletePatientInfo(Long id);

    boolean createPatientInfo(PatientInfoDto dto);

    PatientInfoDto getPatientInfoById(Long id);
}
