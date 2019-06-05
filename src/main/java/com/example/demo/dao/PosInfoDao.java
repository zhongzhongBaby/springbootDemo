package com.example.demo.dao;


import com.example.demo.entity.Vo.PosInfoVo;
import com.example.demo.entity.request.systemManage.FindPosInfoReqeuset;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PosInfoDao  extends BaseDao<PosInfoVo>{
    List<PosInfoVo> findPosList(FindPosInfoReqeuset findPosInfoRequest);
}
