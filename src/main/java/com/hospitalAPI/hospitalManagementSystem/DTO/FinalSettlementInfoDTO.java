package com.hospitalAPI.hospitalManagementSystem.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinalSettlementInfoDTO {
    private String userDefineEmpNo;
    private String empNo;
    private Integer clearanceSlno;
    private Integer mstslNo;
    private String accVoucherno;
    private String udVoucherNo;
    private String autoVoucherNo;




    public String getAccVoucherno() {
        return accVoucherno;
    }

    public void setAccVoucherno(String accVoucherno) {
        this.accVoucherno = accVoucherno;
    }

    public String getUserDefineEmpNo() {
        return userDefineEmpNo;
    }

    public void setUserDefineEmpNo(String userDefineEmpNo) {
        this.userDefineEmpNo = userDefineEmpNo;
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

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
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

