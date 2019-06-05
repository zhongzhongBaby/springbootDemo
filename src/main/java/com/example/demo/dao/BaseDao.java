package com.example.demo.dao;

import com.example.demo.entity.Vo.PosInfoVo;
import com.example.demo.entity.request.RequestBase;
import com.example.demo.entity.request.systemManage.FindPosInfoReqeuset;

import java.util.List;

public interface BaseDao<T> {
    T findById(String id);
    int deleteById(String id);
    int updateById(T t);
    int insert(T t);
}
