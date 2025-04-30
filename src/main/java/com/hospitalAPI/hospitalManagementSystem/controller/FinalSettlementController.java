package com.hospitalAPI.hospitalManagementSystem.controller;

import com.hospitalAPI.hospitalManagementSystem.DTO.FinalSettlementInfoDTO;
import com.hospitalAPI.hospitalManagementSystem.service.Impl.FinalSettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/revert/{empNo}")
    public ResponseEntity<String> revertFinalSettlement(@PathVariable String empNo) {
        if (empNo == null || empNo.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("EMP_NO is required");
        }

        try {
            service.callFinalSettlementRevert(empNo);
            return ResponseEntity.ok("DELETION successfully for EMP_NO: " + empNo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to Do the DELETE OPERATION " + e.getMessage());
        }
    }

}

