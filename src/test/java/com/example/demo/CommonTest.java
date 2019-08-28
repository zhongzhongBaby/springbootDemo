package com.example.demo;

import com.example.demo.aop.Log;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Student;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.text.Collator;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CommonTest {
    @Test
    @Log
    public void mytest()  {

        List<Student> studentList = new ArrayList<>();
        add(studentList);
      /*  List<String> names =studentList.stream().filter(t->t.getAge()>2)
                .sorted(Comparator.comparing(Student::getId).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);*/

        Map<String,List<Student>> as =studentList.stream().collect(Collectors.groupingBy(Student::getName));
        as.keySet().stream().sorted(Comparator.comparing(String::toString)).forEach(c->{
            as.get(c).forEach(System.out::println);
        });

        UserDao  userDao= new UserDao() {
            @Override
            public String findByName() {
                return "name1";
            }
        };

        UserDao  userDao2 =()->"name1";

    }



    void add(List studentList){

        Student student1 = new Student();
        student1.setAge(1);
        student1.setName("name1");
        student1.setId(1);
        student1.setSex(1);
        studentList.add(student1);

        Student student2 = new Student();
        student2.setAge(2);
        student2.setName("name1");
        student2.setId(2);
        student1.setSex(1);
        try {
            student2=(Student)student1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        studentList.add(student2);





        Student student3 = new Student();
        student3.setAge(3);
        student3.setName("name2");
        student3.setId(3);
        student1.setSex(1);
        studentList.add(student3);



        Student student4 = new Student();
        student4.setAge(4);
        student4.setName("name2");
        student4.setId(4);
        student1.setSex(2);
        studentList.add(student4);


        Student student5 = new Student();
        student5.setAge(5);
        student5.setName("name5");
        student5.setId(5);
        student1.setSex(2);
        studentList.add(student5);

    }


}
