package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.aop.Log;
import com.example.demo.customException.MyException;
import com.example.demo.entity.Vo.PosInfoVo;
import com.example.demo.entity.request.systemManage.FindPosInfoReqeuset;
import com.example.demo.entity.response.ResponseBase;
import com.example.demo.service.PosInfoService;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;


@Controller //RestController = response + controller
@RequestMapping(value = "/demo")
public class HomeController {

    @Autowired
    private PosInfoService posInfoService;

    @Log
    @RequestMapping("/home")
    @ResponseBody
    public String home() throws Exception {
//        throw new Exception("系统错误");
        Thread.sleep(4000);
        throw new MyException("101", "自定义错误");
    }





    @RequestMapping(value = "/findPosList",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase findPosList(@RequestBody FindPosInfoReqeuset findPosInfoReqeuset){
        ResponseBase responseBase = new ResponseBase();
        List<PosInfoVo> list=new ArrayList<>();
        try {
            list = posInfoService.findPosList(findPosInfoReqeuset);
        }catch (Exception e){
            e.printStackTrace();
        }
        responseBase.getData().put("list",list);
        return  responseBase;
    }



}
