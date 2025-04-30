//package com.hospitalAPI.hospitalManagementSystem.service.Impl;
//
//import com.hospitalAPI.hospitalManagementSystem.DTO.FinalSettlementInfoDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class FsvDetailsService {
//
//    @Autowired
//    private FsvDetailsRepository repository;
//
//    public List<FinalSettlementInfoDTO> getSettlementInfo(String empNo) {
//        List<Map<String, Object>> rows = repository.getSettlementInfoByUserDefineEmpNo(empNo);
//        return rows.stream().map(row -> {
//            FinalSettlementInfoDTO dto = new FinalSettlementInfoDTO();
//            dto.setUserDefineEmpNo((String) row.get("userDefineEmpNo"));
//            dto.setEmpNo((String) row.get("empNo"));
//            dto.setClearanceSlno((Integer) row.get("clearanceSlno"));
//            dto.setMstslNo((Integer) row.get("mstslNo"));
//            dto.setAccVoucherno((String) row.get("accVoucherno"));
//            dto.setUdVoucherNo((String) row.get("udVoucherNo"));
//            dto.setAutoVoucherNo((String) row.get("autoVoucherNo"));
//            return dto;
//        }).toList();
//    }
//}
