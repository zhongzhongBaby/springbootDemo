package com.example.demo.dao;

import com.example.demo.entity.Course;
import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    Course selectByPrimaryKey(Integer id);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);
}