package com.hospitalAPI.hospitalManagementSystem.service.Interfaces;

import com.hospitalAPI.hospitalManagementSystem.DTO.batchSetupDTO;
import com.hospitalAPI.hospitalManagementSystem.DTO.limsDTO;

import java.util.List;

public interface LimsService {
     List<limsDTO> getFromLims() ;

     List<batchSetupDTO> getFromBatchSetup();
}
