package com.hospitalAPI.hospitalManagementSystem.controller;

import com.hospitalAPI.hospitalManagementSystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @DeleteMapping("/revert/{userDefineEmpNo}")
    public ResponseEntity<String> revertFinalSettlement(@PathVariable String userDefineEmpNo) {
        boolean success = employeeService.revertFinalSettlement(userDefineEmpNo);
        if (success) {
            return ResponseEntity.ok("Final settlement reverted successfully. Employee deleted");
        } else {
            return ResponseEntity.status(500).body("Error occurred while reverting final settlement.");
        }
    }
}
