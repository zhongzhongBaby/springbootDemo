package com.example.demo.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper  extends BaseMapper<Teacher> {
}