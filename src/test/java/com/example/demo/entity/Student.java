package com.example.demo.entity;

public class Student implements Cloneable {

    private int age;
    private String  name;
    private int id;
    private int sex;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", sex=" + sex +
                '}';
    }
}
