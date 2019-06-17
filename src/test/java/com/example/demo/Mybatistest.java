package com.example.demo;

import com.example.demo.dao.PosInfoDao;
import com.example.demo.entity.Vo.PosInfoVo;
import com.example.demo.entity.request.systemManage.FindPosInfoReqeuset;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.List;

public class Mybatistest {

    @Test
    public void testhaha() throws Exception {
        String resource = "mybatis/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PosInfoDao posInfoDao = session.getMapper(PosInfoDao.class);
            List<PosInfoVo> posInfoVos = posInfoDao.findPosList(new FindPosInfoReqeuset());
        } finally {
            session.close();
        }
    }



}
