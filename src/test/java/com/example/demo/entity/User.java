package com.example.demo.entity;

import com.example.demo.AfterOpe;
import com.example.demo.JdbcTest;

public class User {
    final String  s ="";
    private JdbcTest jdbcTest;
    public int getAge() {
        return age;
    }
    @AfterOpe(value = "设置了年龄")
    public void setAge(int age) {
        this.age = age;
    }
private int age;
}
