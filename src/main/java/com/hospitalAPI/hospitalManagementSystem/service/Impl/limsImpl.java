package com.hospitalAPI.hospitalManagementSystem.service.Impl;

import com.hospitalAPI.hospitalManagementSystem.DTO.batchSetupDTO;
import com.hospitalAPI.hospitalManagementSystem.DTO.limsDTO;
import com.hospitalAPI.hospitalManagementSystem.service.Interfaces.LimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
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
            String sql = "SELECT id, product_id, fnc_material_nm(product_id) AS product_name, " +
                    "batch_no, lot_no, batch_size, unit_id, fnc_unit_nm(unit_id) AS unit_name, " +
                    "mfg_date, exp_date, shelf_life, status, remarks, created_at, " +
                    "(SELECT fnc_material_type_nm(material_type_id) " +
                    " FROM lims_material_infos WHERE id = a.product_id) AS product_type " +
                    "FROM lims_batch_infos a " +
                    "WHERE status = 'P' " + // Adjust as needed
                    "ORDER BY created_at DESC";

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<batchSetupDTO> list = new ArrayList<>();

            while (rs.next()) {
                batchSetupDTO dto = new batchSetupDTO();

                dto.setProductId((UUID) rs.getObject("product_id"));
                dto.setProductName(rs.getString("product_name"));
                dto.setProductType(rs.getString("product_type"));
                dto.setBatchNo(rs.getString("batch_no"));
                dto.setLotNo(rs.getString("lot_no"));
                dto.setBatchSize(rs.getString("batch_size"));
                dto.setUnitId((UUID) rs.getObject("unit_id"));
                dto.setUnitName(rs.getString("unit_name"));
                dto.setMfgDate(rs.getDate("mfg_date") != null ? rs.getDate("mfg_date").toLocalDate() : null);
                dto.setExpDate(rs.getDate("exp_date") != null ? rs.getDate("exp_date").toLocalDate() : null);
                dto.setShelfLife(rs.getString("shelf_life"));
                dto.setRemarks(rs.getString("remarks"));
                dto.setStatus(rs.getString("status"));
                dto.setCreatedAt(rs.getTimestamp("created_at") != null ? rs.getTimestamp("created_at").toLocalDateTime() : null);

                list.add(dto);
            }

            rs.close();
            pstmt.close();
            return list;
        });
    }

    @Override
    public boolean updateBatchSetup(UUID id, batchSetupDTO dto) {
        String sql = "UPDATE lims_batch_infos SET " +
                "batch_no = ?, " +
                "lot_no = ?, " +
                "batch_size = ?, " +
                "mfg_date = ?, " +
                "exp_date = ?, " +
                "shelf_life = ?, " +
                "remarks = ?, " +
                "status = ?, " +
                "updated_by = ?, " +
                "updated_at = ? " +
                "WHERE id = ?";

        int rows = thirdJdbcTemplate.update(sql,
                dto.getBatchNo(),
                dto.getLotNo(),
                dto.getBatchSize(),
                dto.getMfgDate() != null ? java.sql.Date.valueOf(dto.getMfgDate()) : null,
                dto.getExpDate() != null ? java.sql.Date.valueOf(dto.getExpDate()) : null,
                dto.getShelfLife(),
                dto.getRemarks(),
                dto.getStatus() != null ? dto.getStatus() : "P",
                dto.getProductId(),
                Timestamp.valueOf(LocalDateTime.now()),
                id
        );
       System.out.println("Updating with parameters: " + dto.getBatchNo() + ", " + dto.getLotNo() + ", " + id);

        return rows > 0;
    }

    @Override
    public boolean deleteBatchSetup(UUID id) {
        String sql = "DELETE FROM lims_batch_infos WHERE id = ?";
        int rows = thirdJdbcTemplate.update(sql, id);
        return rows > 0;
    }
}


//    @Override
//    public boolean updateBatchSetup(UUID id, batchSetupDTO dto) {
//        String sql = "UPDATE lims_batch_infos SET " +
//                "batch_no = ?, lot_no = ?, batch_size = ?, mfg_date = ?, exp_date = ?, shelf_life = ?, remarks = ?, " +
//                "status = ?, updated_by = ?, updated_at = ? " +
//                "WHERE id = ?";
//
//        int rows = thirdJdbcTemplate.update(sql,
//                dto.getBatchNo(),
//                dto.getLotNo(),
//                dto.getBatchSize(),
//                dto.getMfgDate(),
//                dto.getExpDate(),
//                24,
//                dto.getRemarks(),
//                "P",
//                dto.getProductId(),
//                LocalDateTime.now(),
//                id
//        );
//
//        return rows > 0;
//    }
//}

//---------------------------------------------------------------------------------------

//UPDATE lims_batch_infos
//        SET
//                batch_no = 'T135560',
//                lot_no = '50',
//                batch_size = '400000',
//                mfg_date = DATE '2025-04-06',
//exp_date = DATE '2027-04-06',
//shelf_life = '24',
//remarks = '',
//status = 'P',
//updated_by = '5c7a1f3b-f5c4-496f-8d7f-1ba099448e8c',
//updated_at = TIMESTAMP '2025-04-22 16:56:06.505'
//WHERE id = 'ee3f3764-e651-4b88-b5e6-5a03ca978432';
//
