package com.example.demo.controller;


import com.example.demo.dao.TeacherMapper;
import com.example.demo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/demo")
public class HomeController {
    @Autowired
    private TeacherMapper teacherMapper;

    @RequestMapping("/findTeachers")
    public Map home(@RequestParam(name = "campusId", required = false) Integer campusId) throws Exception {
        Map m = new HashMap();
        m.put("teachers", teacherMapper.selectById("1"));
      /*
        for (Teacher t : teacherMa1pper.selectAll()) {
            m.put("teachers" + (i++), t.toString());
        }*/
        return m;
    }

    @RequestMapping("/addTeacher")
    public Map home2(@RequestParam(name = "campusId", required = false) Integer campusId) throws Exception {
        Map m = new HashMap();
        Teacher teacher=new Teacher();
        teacher.setCreateDate(new Date());
        m.put("i",teacherMapper.insert(teacher));
        return m;
    }


}
