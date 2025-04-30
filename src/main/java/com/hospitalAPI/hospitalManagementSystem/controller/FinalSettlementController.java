package com.hospitalAPI.hospitalManagementSystem.controller;

import com.hospitalAPI.hospitalManagementSystem.DTO.FinalSettlementInfoDTO;
import com.hospitalAPI.hospitalManagementSystem.service.Impl.FinalSettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/final-settlement")
public class FinalSettlementController {

    @Autowired
    private FinalSettlementService service;

    @PostMapping("/revert")
    public ResponseEntity<String> revertFinalSettlement(@RequestBody FinalSettlementInfoDTO request) {
        service.callFinalSettlementRevert(request.getEmpNo());
        return ResponseEntity.ok("Final settlement reverted successfully for EMP_NO: " + request.getEmpNo());
    }
}

