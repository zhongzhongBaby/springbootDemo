package com.example.demo.controller;

import com.example.demo.aop.Log;
import com.example.demo.customException.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller //RestController = response + controller
@RequestMapping(value = "/demo")
public class HomeController {



    @Log
    @RequestMapping("/home")
    @ResponseBody
    public String home() throws Exception {
//        throw new Exception("系统错误");
        Thread.sleep(4000);
        throw new MyException("101", "自定义错误hahhahahahhaha");
    }


}
