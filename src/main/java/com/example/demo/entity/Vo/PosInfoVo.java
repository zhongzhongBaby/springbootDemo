package com.example.demo.entity.Vo;



import java.util.Date;

public class PosInfoVo   {

    private String id;
    private String posNumber;
    private Date updateDate;
    private String campusName;
    private String campusId;
    private String remarks;
    private String posStatus;
    private String posStatusLabel;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosNumber() {
        return posNumber;
    }

    public void setPosNumber(String posNumber) {
        this.posNumber = posNumber;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPosStatus() {
        return posStatus;
    }

    public void setPosStatus(String posStatus) {
        this.posStatus = posStatus;
    }

    public String getPosStatusLabel() {
        return posStatusLabel;
    }

    public void setPosStatusLabel(String posStatusLabel) {
        this.posStatusLabel = posStatusLabel;
    }





}
