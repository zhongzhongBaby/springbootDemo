package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    int insert(Teacher record);

    @Select("select create_date from teacher")
    List<String> selectAll();
}