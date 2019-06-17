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

        headerList.add("班级名称");
        headerList.add("收费内容");
        headerList.add("购课");
        headerList.add("总课次");
        headerList.add("退费课次");
        headerList.add("应付价格");
        headerList.add("实付价格");
        headerList.add("课次退费");
        headerList.add("额外退费");
        headerList.add("其他退费");
        headerList.add("退费总额");
        headerList.add("打款金额");
        headerList.add("状态");
        headerList.add("打款流水号");
        headerList.add("操作人");
     /*   headerList.add("退费原因");
        headerList.add("备注");*/

        List<Object> fields = new ArrayList<>();
        fields.add("createDate"); // 发起时间
        fields.add("refundRecordNo"); // 退费单流水号
        fields.add("campusName"); // 校区名称
        fields.add("financeName"); // 财务主体
        fields.add("studentName"); // 学员名称
        fields.add("studentPhone"); // 联系电话
        List<Object> children = new ArrayList<>();
        children.add("className"); // 班级名称
        children.add("chargeName"); // 收费内容
        children.add("payAttendCount"); // 购课
        children.add("totalTimes"); // 总课次
        children.add("refundAttendNumber"); // 退费课次
        children.add("price"); // 应付价格
        children.add("realPayment"); // 实付价格
        children.add("classRefundAmount"); // 课次退费
        children.add("otherRefundAmount"); // 额外退费
        children.add("otherOrderRefundAmount"); // 其他退费
        children.add("realRefundAmount"); // 退费总额
        fields.add(children);
        fields.add("remitAmount"); // 打款金额1
        fields.add("statusLabel"); // 状态
        fields.add("remitNo"); // 打款流水号
        fields.add("updateByName"); // 操作人
      /*  fields.add("studentName"); // 退费原因
        fields.add("studentPhone"); // 备注 */

        //临时缓冲区
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WritableWorkbook wk = Workbook.createWorkbook(outputStream);
        WritableSheet sheet = wk.createSheet("退费列表", 0);
        for (int i = 0; i < fields.size() + children.size() - 1; i++) {
            sheet.setColumnView(i, 20);
        }
        JXLUtil.writeExcelTitle(headerList.size(), sheet, "退费列表");
        JXLUtil.writeExcelColumnTitle(headerList, sheet);
        int startRow = 2;//从第3行开始写

        int limit = 10;
        int page = 1;
        int count =2000;
        limit = 125;
        // 计算页数
        Integer length = (count + limit - 1) / limit;  // 计算页数
        for (int i = 1; i <= length; i++) {
            page = i;
            List<Map<String, Object>> result =  new ArrayList<>() ;
            //添加假数据
            for(int h=0;h<limit;h++){
                Map<String, Object>  m=new HashMap<>();
                m.put("createDate",h); // 发起时间
                m.put("refundRecordNo",h); // 退费单流水号
                m.put("campusName",h); // 校区名称
                m.put("financeName",h); // 财务主体
                m.put("studentName",h); // 学员名称
                m.put("studentPhone",h); // 联系电话
                m.put("remitAmount",h); // 打款金额1
                m.put("statusLabel",h); // 状态
                m.put("remitNo",h); // 打款流水号
                m.put("updateByName",h); // 操作人
                List<Map<String, Object>> orders=new ArrayList<>();
                int childnum=(int)(Math.random()*5);
                for(int c=0;c<childnum;c++){
                    Map<String, Object>  childM=new HashMap<>();
                    childM.put("className",h); // 班级名称
                    childM.put("chargeName",h); // 收费内容
                    childM.put("payAttendCount",h); // 购课
                    childM.put("totalTimes",h); // 总课次
                    childM.put("refundAttendNumber",h); // 退费课次
                    childM.put("price",h); // 应付价格
                    childM.put("realPayment",h); // 实付价格
                    childM.put("classRefundAmount",h); // 课次退费
                    childM.put("otherRefundAmount",h); // 额外退费
                    childM.put("otherOrderRefundAmount",h); // 其他退费
                    childM.put("realRefundAmount",h); // 退费总额
                    orders.add(childM);
                }
                m.put("order",orders);
                result.add(m);
            }
            startRow = JXLUtil.writeExcelContent(sheet, fields, result, startRow);
        }
        JXLUtil.writeExcelByJxl(response,wk,outputStream);
    }

}
