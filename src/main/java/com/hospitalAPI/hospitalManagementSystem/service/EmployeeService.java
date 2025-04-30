package com.hospitalAPI.hospitalManagementSystem.service;


import org.springframework.stereotype.Service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeService(@Qualifier("fourthJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean revertFinalSettlement(String userDefineEmpNo) {
        try {
            // Call the stored procedure using the fourth JdbcTemplate
            jdbcTemplate.update("BEGIN MMI_LIVE.PRC_FINALSETTLEMENTREVERT(?); END;", userDefineEmpNo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();  // Handle exceptions properly
            return false;
        }
    }
}

