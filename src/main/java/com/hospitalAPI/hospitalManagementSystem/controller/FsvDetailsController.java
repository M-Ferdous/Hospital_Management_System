//package com.hospitalAPI.hospitalManagementSystem.controller;
//
//import com.hospitalAPI.hospitalManagementSystem.DTO.FinalSettlementInfoDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/final-settlement")
//public class FsvDetailsController {
//
//    @Autowired
//    private FsvDetailsService service;
//
//    @GetMapping("/info/{empNo}")
//    public ResponseEntity<List<FinalSettlementInfoDTO>> getInfo(@PathVariable String empNo) {
//        return ResponseEntity.ok(service.getSettlementInfo(empNo));
//    }
//}
