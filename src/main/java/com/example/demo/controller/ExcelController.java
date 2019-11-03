package com.example.demo.controller;

import com.example.demo.aop.Log;
import com.example.demo.entity.response.ResponseBase;
import com.example.demo.service.ExcelService;
import com.example.demo.utils.JXLUtil;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/demo/excel")
public class ExcelController {
    @Autowired
    private ExcelService  excelService;
    @Log
    @RequestMapping("/export")
    public void export(HttpServletResponse response, HttpServletRequest request) throws Exception {


    }
    @Log
    @ResponseBody
    @RequestMapping(value = "/importExcelFile",method = RequestMethod.POST)
    public ResponseBase importCityList(@RequestParam("file") MultipartFile file){
        ResponseBase responseBase = new ResponseBase();
        Map<String,String> map=new HashMap<>();
        map.put("姓名","name");
        map.put("班级","classname");
        map.put("笔试成绩","score1");
        map.put("上机成绩","scorse2");
        map.put("考试日期","date");

        try {
            /*测试开始*/
            //读取文件要getWorkbook
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheet(0);
            List<HashMap<String,Object>> testmaps= JXLUtil.readExcelByJxl(file.getInputStream(),map);
            responseBase.getData().put("list",testmaps);
            workbook.close();
            /*测试结束*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return  responseBase;
    }






}
