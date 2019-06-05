package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class EntityBase implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore //在json序列化时将java bean中的一些属性忽略掉
    private boolean delFlag = false; //逻辑删除
    private String id; // 数据唯一标识

}
