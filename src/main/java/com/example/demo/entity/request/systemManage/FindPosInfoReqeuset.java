package com.example.demo.entity.request.systemManage;

import com.example.demo.entity.request.FindRequestBase;

import java.util.List;

public class FindPosInfoReqeuset extends FindRequestBase {
    private String posNumber;
    private String status;
    private String campusId;
    private List<String> campusIdList;

    public String getPosNumber() {
        return posNumber;
    }

    public void setPosNumber(String posNumber) {
        this.posNumber = posNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public List<String> getCampusIdList() {
        return campusIdList;
    }

    public void setCampusIdList(List<String> campusIdList) {
        this.campusIdList = campusIdList;
    }


}
