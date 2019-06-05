package com.example.demo;

public class User {
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
