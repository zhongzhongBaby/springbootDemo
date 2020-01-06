package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.entity.Teacher;
import com.example.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/demo")
public class HomeController {
    @Autowired
    private TeacherMapper teacherMapper;

    @RequestMapping("/findTeachers")
    public Map home(@RequestParam(name = "campusId", required = false) Integer campusId) throws Exception {
        Map m = new HashMap();
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name","create_date");
        queryWrapper.eq("name", 1);
        List<Map<String, Object>> teachers= teacherMapper.selectMaps(queryWrapper);
        teachers.forEach(c->{
            CommonUtils.mapRenameKeyToHump(c);
        });
        m.put("teachers", teachers);

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
