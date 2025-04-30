package com.hospitalAPI.hospitalManagementSystem.DTO;

import lombok.Data;

@Data
public class FsvDetailsEntity {


    private Long id; // You can replace with actual PK if available

    private String userDefineEmpNo;

    private String empNo;

    private Integer clearanceSlno;

    private Integer mstslNo;

    private String accVoucherno;

    private String udVoucherNo;

    private String autoVoucherNo;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserDefineEmpNo() {
        return userDefineEmpNo;
    }

    public void setUserDefineEmpNo(String userDefineEmpNo) {
        this.userDefineEmpNo = userDefineEmpNo;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Integer getClearanceSlno() {
        return clearanceSlno;
    }

    public void setClearanceSlno(Integer clearanceSlno) {
        this.clearanceSlno = clearanceSlno;
    }

    public Integer getMstslNo() {
        return mstslNo;
    }

    public void setMstslNo(Integer mstslNo) {
        this.mstslNo = mstslNo;
    }

    public String getAccVoucherno() {
        return accVoucherno;
    }

    public void setAccVoucherno(String accVoucherno) {
        this.accVoucherno = accVoucherno;
    }

    public String getUdVoucherNo() {
        return udVoucherNo;
    }

    public void setUdVoucherNo(String udVoucherNo) {
        this.udVoucherNo = udVoucherNo;
    }

    public String getAutoVoucherNo() {
        return autoVoucherNo;
    }

    public void setAutoVoucherNo(String autoVoucherNo) {
        this.autoVoucherNo = autoVoucherNo;
    }
}
