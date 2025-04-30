package com.hospitalAPI.hospitalManagementSystem.service.Impl;

import com.hospitalAPI.hospitalManagementSystem.DTO.FinalSettlementInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class FinalSettlementService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FinalSettlementService(@Qualifier("fourthJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void revertFinalSettlement(String empNo) {
        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement cs = connection.prepareCall("{call MMI_LIVE.PRC_FINALSETTLEMENTREVERT(?)}")) {
                cs.setString(1, empNo);
                cs.execute();
                return null;
            }
        });
    }

    public List<FinalSettlementInfoDTO> callFinalSettlementRevert(String empNo) {
        return jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement cs = connection.prepareCall("{call MMI_LIVE.PRC_FINALSETTLEMENTREVERT(?)}")) {
                cs.setString(1, empNo);
                boolean hasResult = cs.execute();
                ResultSet rs = cs.getResultSet();

                List<FinalSettlementInfoDTO> resultList = new ArrayList<>();

                if (hasResult) {
                    try (ResultSet rs1 = cs.getResultSet()) {
                        while (rs.next()) {
                            FinalSettlementInfoDTO dto = new FinalSettlementInfoDTO();
                            dto.setUserDefineEmpNo(rs.getString("USER_DEFINE_EMP_NO"));
                            dto.setEmpNo(rs.getString("EMP_NO"));
                            dto.setClearanceSlno(rs.getInt("CLEARANCE_SLNO"));
                            dto.setMstslNo(rs.getInt("MSTSL_NO"));
                            dto.setAccVoucherno(rs.getString("ACC_VOUCHERNO"));
                            dto.setUdVoucherNo(rs.getString("UD_VOUCHER_NO"));
                            dto.setAutoVoucherNo(rs.getString("AUTO_VOUCHER_NO"));
                            resultList.add(dto);
                        }
                    }
                }

                return resultList;
            }
        });
    }

}
