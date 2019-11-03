package com.example.demo.service;

import com.example.demo.utils.JXLUtil;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@Service
public class ExcelService {

    public void exportFindBigRefundOrderList(HttpServletResponse response) throws WriteException, IOException {
        List<String> headerList = new ArrayList<>();
        headerList.add("发起时间");
        headerList.add("退费ID");
        headerList.add("校区");
        headerList.add("财务主体");
        headerList.add("学员名称");
        headerList.add("联系电话");
        List<Object> fields = new ArrayList<>();
        fields.add("createDate"); // 发起时间
        fields.add("refundRecordNo"); // 退费单流水号
        fields.add("campusName"); // 校区名称
        fields.add("financeName"); // 财务主体
        fields.add("studentName"); // 学员名称
        fields.add("studentPhone"); // 联系电话

        //临时缓冲区
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WritableWorkbook wk = Workbook.createWorkbook(outputStream);
        WritableSheet sheet = wk.createSheet("退费列表", 0);
        JXLUtil.writeExcelTitle(headerList.size(), sheet, "退费列表");
        JXLUtil.writeExcelColumnTitle(headerList, sheet);
        List<Map<String, Object>> result= new ArrayList<>();
        int startRow = 2;//从第3行开始写
            for(int h=0;h<10;h++) {
                Map<String, Object> m = new HashMap<>();
                m.put("createDate", h); // 发起时间
                m.put("refundRecordNo", h); // 退费单流水号
                m.put("campusName", h); // 校区名称
                m.put("financeName", h); // 财务主体
                m.put("studentName", h); // 学员名称
                m.put("studentPhone", h); // 联系电话
                result.add(m);
            }
            startRow = JXLUtil.writeExcelContent(sheet, fields, result, startRow);
        JXLUtil.writeExcelByJxl(response,wk,outputStream);
    }
}
