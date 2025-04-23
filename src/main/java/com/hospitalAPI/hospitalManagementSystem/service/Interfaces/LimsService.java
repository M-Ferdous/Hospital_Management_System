package com.hospitalAPI.hospitalManagementSystem.service.Interfaces;

import com.hospitalAPI.hospitalManagementSystem.DTO.batchSetupDTO;
import com.hospitalAPI.hospitalManagementSystem.DTO.limsDTO;

import java.util.List;
import java.util.UUID;

public interface LimsService {
     List<limsDTO> getFromLims() ;

     List<batchSetupDTO> getFromBatchSetup();

     boolean updateBatchSetup(UUID id, batchSetupDTO dto);

     boolean deleteBatchSetup(UUID id);
}
