package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseDao<T> {
    T findById(String id);
    int deleteById(String id);
    int updateById(T t);
    int insert(T t);
}
