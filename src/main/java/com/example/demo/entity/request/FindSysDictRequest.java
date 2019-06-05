package com.example.demo.entity.request;

import java.util.List;

public class FindSysDictRequest extends FindRequestBase {

    private String type; //类型
    private String label; //文字值
    private String value; //value值

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
