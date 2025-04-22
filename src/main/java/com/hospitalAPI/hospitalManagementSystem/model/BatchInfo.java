package com.hospitalAPI.hospitalManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.security.Timestamp;
import java.util.Date;
import java.util.UUID;

public class BatchInfo {
    package ati.lims.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

    @Entity
    @Table(name = "lims_batch_infos")
    public class BatchInfo {

        @Id
        @Column(name = "id")
        @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;

        @Column(name = "product_id")
        private UUID productId;

        @Transient
        private String productName;

        @Column(name = "batch_no")
        private String batchNo;

        @Column(name = "lot_no")
        private String lotNo;

        @Column(name = "batch_size")
        private String batchSize;

        @Column(name = "unit_id")
        private UUID unitId;

        @Transient
        private String unitName;

        @JsonSubTypes.Type(type = "date")
        @Column(name = "batch_date")
        private Date batchDate;

        @JsonSubTypes.Type(type = "date")
        @Column(name = "mfg_date")
        private Date mfgDate;

        @JsonSubTypes.Type(type = "date")
        @Column(name = "exp_date")
        private Date expDate;

        @Column(name = "shelf_life")
        private String shelfLife;

        @Transient
        private String remarks;
        //@Column(name = "status")
        @Transient
        private String status;

        @Transient
        private Timestamp createdAt;

        @Transient
        private String productType;



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


        public String getRemarks() {
            return remarks;
        }


        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }


        public UUID getId() {
            return id;
        }


        public void setId(UUID id) {
            this.id = id;
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


        public String getStatus() {
            return status;
        }


        public void setStatus(String status) {
            this.status = status;
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





    }

}
