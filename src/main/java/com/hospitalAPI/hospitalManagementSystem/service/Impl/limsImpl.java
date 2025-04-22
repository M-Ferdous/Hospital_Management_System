package com.hospitalAPI.hospitalManagementSystem.service.Impl;

import com.hospitalAPI.hospitalManagementSystem.DTO.batchSetupDTO;
import com.hospitalAPI.hospitalManagementSystem.DTO.limsDTO;
import com.hospitalAPI.hospitalManagementSystem.service.Interfaces.LimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class limsImpl implements LimsService {

    @Autowired
    @Qualifier("thirdJdbcTemplate")
    private JdbcTemplate thirdJdbcTemplate;

    @Override
    public List<limsDTO> getFromLims() {
        return thirdJdbcTemplate.execute((Connection con) -> {
            String sql = "select id, type_no, type_name, remarks, " +
                    "status from lims_material_type_infos where" +
                    " company_id = '9b4169c4-84c8-4f15-adf8-976ab433c343' ";

            PreparedStatement pstmt = con.prepareStatement(sql);
         // pstmt.setInt(1, Integer.parseInt("9b4169c4-84c8-4f15-adf8-976ab433c343"));

            ResultSet rs = pstmt.executeQuery();

            List<limsDTO> list = new ArrayList<>();
            while (rs.next()) {
                limsDTO dto = new limsDTO();
                dto.setId((UUID) rs.getObject("id"));
                dto.setRemarks(rs.getString("remarks"));
                dto.setStatus(rs.getString("status"));
                dto.setTypeName(rs.getString("type_name"));
               dto.setTypeNo(rs.getString("type_no"));
                list.add(dto);
            }

            rs.close();
            pstmt.close();
            return list;
        });
    }

    @Override
    public List<batchSetupDTO> getFromBatchSetup() {
        return thirdJdbcTemplate.execute((Connection con) -> {
            String sql = "select id, product_id,fnc_material_nm(product_id) product_name, batch_no, lot_no, batch_size, " +
                    " unit_id,fnc_unit_nm(unit_id) unit_name, mfg_date, exp_date, shelf_life, status,remarks,created_at," +
                    " (select fnc_material_type_nm(material_type_id) from lims_material_infos" +
                    " where id=a.product_id) product_type   from lims_batch_infos a " +
                    "where  status=status  order by created_at desc ";

            PreparedStatement pstmt = con.prepareStatement(sql);
            // pstmt.setInt(1, Integer.parseInt("9b4169c4-84c8-4f15-adf8-976ab433c343"));

            ResultSet rs = pstmt.executeQuery();

            List<batchSetupDTO> list = new ArrayList<>();
            while (rs.next()) {
                limsDTO dto1 = new limsDTO();
                batchSetupDTO dto = new  batchSetupDTO();
                dto1.setId((UUID) rs.getObject("id"));
                dto1.setRemarks(rs.getString("remarks"));
                dto1.setStatus(rs.getString("status"));
                // dto1.setTypeName(rs.getString("type_name"));
                //dto.setTypeNo(rs.getString("type_no"));

                //new for batch setup ( Production Dashboard)
                dto.setProductId((UUID) rs.getObject("product_id"));
                dto.setProductName(rs.getString("product_name"));
                dto.setProductType(rs.getString("product_type"));
                dto.setBatchNo(rs.getString("batch_no"));
                dto.setLotNo(rs.getString("lot_no"));
                dto.setBatchSize(rs.getString("batch_size"));
                dto.setUnitId((UUID) rs.getObject("unit_id"));
                dto.setUnitName(rs.getString("unit_name"));
                dto.setMfgDate(rs.getDate("mfg_date"));
                dto.setExpDate(rs.getDate("exp_date"));
                // dto.setCreatedAt(rs.getTimestamp("created_at"));
                dto.setShelfLife(rs.getString("shelf_life"));
                list.add(dto);
            }

            rs.close();
            pstmt.close();
            return list;
        });
    }

}
