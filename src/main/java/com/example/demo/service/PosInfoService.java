package com.example.demo.service;

import com.example.demo.annotioon.ChangeDS;
import com.example.demo.dao.PosInfoDao;
import com.example.demo.entity.Vo.PosInfoVo;
import com.example.demo.entity.request.systemManage.FindPosInfoReqeuset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PosInfoService {
    @Autowired
    private PosInfoDao posInfoDao;

    @ChangeDS(type="select")
    public List<PosInfoVo> findPosList(FindPosInfoReqeuset findPosInfoReqeuset) {
        List<PosInfoVo> posInfoVos=new ArrayList<>();
        posInfoVos.add((PosInfoVo)posInfoDao.findById(findPosInfoReqeuset.getId()));
        return posInfoVos;
    }
}
