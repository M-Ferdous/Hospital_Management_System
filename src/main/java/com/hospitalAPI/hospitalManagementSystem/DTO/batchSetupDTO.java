package com.hospitalAPI.hospitalManagementSystem.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private LocalDate batchDate;
    private LocalDate mfgDate;
    private LocalDate expDate;

    private String shelfLife;
    private LocalDateTime createdAt;

    private String productType;
    private String remarks;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public void setMfgDate(LocalDate mfgDate) {
        this.mfgDate = mfgDate;
    }

    public void setBatchDate(LocalDate batchDate) {
        this.batchDate = batchDate;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setUnitId(UUID unitId) {
        this.unitId = unitId;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }



    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public String getLotNo() {
        return lotNo;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public UUID getUnitId() {
        return unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public LocalDate getBatchDate() {
        return batchDate;
    }

    public LocalDate getMfgDate() {
        return mfgDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getProductType() {
        return productType;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getStatus() {
        return status;
    }


}
