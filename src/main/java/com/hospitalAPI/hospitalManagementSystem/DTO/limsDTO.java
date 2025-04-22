package com.hospitalAPI.hospitalManagementSystem.DTO;

import lombok.Getter;
import lombok.Setter;
import org.postgresql.jdbc.TimestampUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.security.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class limsDTO {


    private UUID id;


    private String typeNo;

    private String typeName;

    private String remarks;

    private String status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}


