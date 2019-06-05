package com.example.demo.entity.request;

import java.io.Serializable;

public class RequestBase  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String ids;
    private String userid; //记录用户操作等
    private String operationType; // 接口请求类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }


}
