package com.hospitalAPI.hospitalManagementSystem.DTO;

import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class batchSetupDTO {



    private UUID productId;

    private String productName;

    private String batchNo;

    private String lotNo;

    private String batchSize;

    private UUID unitId;

    private String unitName;

    private Date batchDate;

    private Date mfgDate;

    private Date expDate;

    private String shelfLife;


    private Timestamp createdAt;

    private String productType;


    private String remarks;

    private String status;




    public String getProductType() {
        return productType;
    }


    public void setProductType(String productType) {
        this.productType = productType;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public String getBatchNo() {
        return batchNo;
    }


    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }


    public String getLotNo() {
        return lotNo;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }


    public String getBatchSize() {
        return batchSize;
    }


    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }


    public Date getBatchDate() {
        return batchDate;
    }


    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }


    public Date getMfgDate() {
        return mfgDate;
    }


    public void setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
    }


    public Date getExpDate() {
        return expDate;
    }


    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }


    public String getShelfLife() {
        return shelfLife;
    }


    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }


    public UUID getProductId() {
        return productId;
    }


    public void setProductId(UUID productId) {
        this.productId = productId;
    }


    public UUID getUnitId() {
        return unitId;
    }


    public void setUnitId(UUID unitId) {
        this.unitId = unitId;
    }


    public String getUnitName() {
        return unitName;
    }


    public void setUnitName(String unitName) {
        this.unitName = unitName;
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
