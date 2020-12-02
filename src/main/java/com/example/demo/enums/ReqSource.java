package com.example.demo.enums;

public enum ReqSource implements KeyValueEnumBase{
    PC("1","电脑端"),
    APP("2","小程序端");

    private String value,label;
    ReqSource(String value,String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getValue() {
        return value;
    }
}
