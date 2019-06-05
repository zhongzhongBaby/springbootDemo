package com.example.demo.controller;

import com.example.demo.customException.MyException;
import com.example.demo.entity.Vo.PosInfoVo;
import com.example.demo.entity.request.systemManage.FindPosInfoReqeuset;
import com.example.demo.entity.response.ResponseBase;
import com.example.demo.service.PosInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController //RestController = response + controller
@RequestMapping(value = "/demo")
public class HomeController {
    @Autowired
    private PosInfoService posInfoService;

    @RequestMapping("/home")
    public String home() throws Exception {
//        throw new Exception("系统错误");
        Thread.sleep(4000);
        throw new MyException("101", "自定义错误");
    }

    @RequestMapping(value = "/findPosList",method = RequestMethod.POST)
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
