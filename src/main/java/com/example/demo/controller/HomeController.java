package com.example.demo.controller;

import com.example.demo.aop.Log;
import com.example.demo.customException.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RestController//RestController = response + controller
@RequestMapping(value = "/demo")
public class HomeController {


    @Log
    @RequestMapping("/home")
    public Map home() throws Exception {
        System.out.println("我就是方法本法");
        Map m = new HashMap();
        m.put("dasda", "asd");
        return m;
    }

}
