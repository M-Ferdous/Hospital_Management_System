package com.hospitalAPI.hospitalManagementSystem.service.Impl;

import com.hospitalAPI.hospitalManagementSystem.DTO.RefByUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RefByUpdateService {

    @Autowired
    @Qualifier("fourthJdbcTemplate")  // Use the fourth JdbcTemplate bean
    private JdbcTemplate jdbcTemplate;

    public String updateRefBy(RefByUpdateDTO dto) {
        try {
            // Prepare stored procedure call
            String sql = "{ call MMI_LIVE.PRC_REFBYUPDATE(?, ?) }";

            // Call stored procedure
            jdbcTemplate.update(sql, dto.getEmpNo(), dto.getVoucherNo());

            return "Employee updated successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Employee update failed!";
        }
    }
}
