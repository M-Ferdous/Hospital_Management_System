package com.hospitalAPI.hospitalManagementSystem.controller;

import com.hospitalAPI.hospitalManagementSystem.DTO.RefByUpdateDTO;
import com.hospitalAPI.hospitalManagementSystem.service.Impl.RefByUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefByUpdateController {

    @Autowired
    private RefByUpdateService refByUpdateService;

    @PutMapping("/updateRefBy")
    public ResponseEntity<String> updateRefBy(@RequestBody RefByUpdateDTO dto) {
        String result = refByUpdateService.updateRefBy(dto);
        return ResponseEntity.ok(result);
    }
}

