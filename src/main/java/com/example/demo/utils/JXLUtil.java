package com.example.demo.utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

public class JXLUtil {

    /**
     * @Description: 生成excel的标题
     * @Param: [colLength, sheet, name]
     * @Author: gengyuzhong
     * @Date: 2019/6/14
     */
    public static void writeExcelTitle(int colLength, WritableSheet sheet, String name) throws WriteException {
        sheet.mergeCells(0, 0, colLength - 1, 0);//单元格合并方法
        //创建WritableFont 字体对象，参数依次表示黑体、字号12、粗体、非斜体、不带下划线、亮蓝色
        WritableFont titleFont = new WritableFont(WritableFont.createFont("黑体"), 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.LIGHT_BLUE);
        //创建WritableCellFormat对象，将该对象应用于单元格从而设置单元格的样式
        WritableCellFormat titleFormat = new WritableCellFormat();
        //设置字体格式
        titleFormat.setFont(titleFont);
        //设置文本水平居中对齐
        titleFormat.setAlignment(jxl.format.Alignment.CENTRE);
        //设置文本垂直居中对齐
        titleFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
        //设置背景颜色
        titleFormat.setBackground(Colour.GRAY_25);
        //设置自动换行
        titleFormat.setWrap(true);
        //添加Label对象，参数依次表示在第一列，第一行，内容，使用的格式
        Label lab_00 = new Label(0, 0, name, titleFormat);
        //将定义好的Label对象添加到工作表上，这样工作表的第一列第一行的内容为‘学员考试成绩一览表’并应用了titleFormat定义的样式
        sheet.addCell(lab_00);
    }


    /**
     * @Description: 返回excel 字段对应的列下标  （合并单元格的时候用到）
     * @Param: [fields]
     * @Author: gengyuzhong
     * @Date: 2019/6/15
     */
    public static Map<String, Integer> findFiledToColIndex(List<Object> fields) {
        Map<String, Integer> map = new HashMap<>();
        int colIndex = 0;
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i) instanceof List) {
                List<Object> childList = (ArrayList) (fields.get(i));
                colIndex += childList.size();
            } else {
                map.put(fields.get(i).toString(), colIndex++);
            }
        }
        return map;
    }


    /**
     * @Description: 使用jxl生成excel列标题
     * @Param: [columns, sheet]
     * @Author: gengyuzhong
     * @Date: 2019/6/14
     */
    public static void writeExcelColumnTitle(List<String> columns, WritableSheet sheet) throws WriteException {
        WritableCellFormat cloumnTitleFormat = new WritableCellFormat();
        cloumnTitleFormat.setFont(new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false));
        cloumnTitleFormat.setAlignment(Alignment.CENTRE);
        cloumnTitleFormat.setBackground(Colour.GRAY_50);
        //设置自动换行
        cloumnTitleFormat.setWrap(true);
        if (columns.size() > 0) {
            int i = 0;
            for (String key : columns) {
                sheet.addCell(new Label(i, 1, key, cloumnTitleFormat));
                i++;
            }
        }
    }


    /**
     * @Description: 使用jxl写入内容
     * @Param: [sheet, fields (字段key),list, startRow（开始写入行）]
     * @Author: gengyuzhong
     * @Date: 2019/6/14
     */
    public static int writeExcelContent(WritableSheet sheet, List<Object> fields, List<Map<String, Object>> list, int startRow) throws WriteException {
        String field = null;
        String value = null;
        WritableCellFormat cellFormat = new WritableCellFormat();
        cellFormat.setWrap(true);
        cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
        cellFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
        for (int k = 0; k < list.size(); k++, startRow++) {  //k是总数据量
            int mergeStartRow = startRow;
            int startRowTemp = startRow;
            int childResultSize = 0;
            for (int startCol = 0, j = 0; j < fields.size(); startCol++, j++) { //j是第几列
                if (fields.get(j) instanceof String) {
                    field = fields.get(j).toString();
                    value = list.get(k).get(field) != null ? list.get(k).get(field).toString() : "";
                    sheet.addCell(new Label(startCol, startRowTemp, value, cellFormat));
                } else if (fields.get(j) instanceof List) {
                    List<Object> childFields = (ArrayList) (fields.get(j));
                    List<Map<String, Object>> childResult = (ArrayList) (list.get(k).get("order"));
                    childResultSize = childResult.size();
                    for (int cr = 0; cr < childResult.size(); cr++, startRowTemp++) {
                        int startColTemp = startCol;
                        for (int cc = 0; cc < childFields.size(); cc++, startColTemp++) {
                            field = childFields.get(cc).toString();
                            if (childResult.get(cr).get(field) != null) {
                                value = childResult.get(cr).get(field).toString();
                                sheet.addCell(new Label(startColTemp, startRowTemp, value, cellFormat));
                            }
                        }
                    }
                    startRowTemp = startRow;////下一个非list字段开始的行
                    startCol += childFields.size() - 1; //下一个非list字段开始的列-1
                }
            }
            if (childResultSize > 0) {
                startRow += childResultSize - 1; //下一条总数居开始的行-1
                //对每一条总数据进行合并单元
                Map<String, Integer> map = findFiledToColIndex(fields);
                for (Object o : fields) {
                    if (o instanceof String) {
                        int mergeColIndex = map.get(o.toString());
                        sheet.mergeCells(mergeColIndex, mergeStartRow, mergeColIndex, startRow);//单元格合并方法
                    }
                }
            }
        }
        return startRow;
    }

    /**
     * @Description: 通过jxl下载excel  （带下载进度条）
     * @Param: [response, fileName]
     * @Author: gengyuzhong
     * @Date: 2019/6/14
     */
    public static void writeExcelByJxl(HttpServletResponse response, WritableWorkbook wk, ByteArrayOutputStream outputStream) throws IOException {
        byte[] buf = new byte[1024];
        int len = 0;
        InputStream in = null;
        long startTime=new Date().getTime();
        wk.write();
        long endTime=new Date().getTime();
        System.out.println("输出到流耗时"+(endTime-startTime)/1000);
        try {
            wk.close();
        } catch (WriteException e) {
            e.printStackTrace();
        }
        byte[] bookByteAry = outputStream.toByteArray();
        in = new ByteArrayInputStream(bookByteAry);
        System.out.print("++++++++++++++++++++++++++++++");
        System.out.println("流的大小"+String.valueOf(in.available()));
        System.out.print("-------------------------------");
        response.reset();
        response.setHeader("Content-Type", "text/event-stream");//设置服务器端事件流
        response.setHeader("Cache-Control", "no-cache");//规定不对页面进行缓存
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Access-Control-Allow-Methods", "");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Content-Encoding", "UTF-8");
        response.addHeader("Content-Length", String.valueOf(in.available()));
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("校区列表信息.xlsx", "UTF-8"));
        //读取文件;
        OutputStream myOut = response.getOutputStream();
        while ((len = in.read(buf)) > 0) {
            myOut.write(buf, 0, len);
        }
        myOut.close();
    }

    /**
     * @Description: 通过jxl读取excel的内容
     * @Param: [inputStream, fieldMap（记录列标题对应的字段）]
     * @Author: gengyuzhong
     * @Date: 2019/6/14
     */
    public static List<HashMap<String, Object>> readExcelByJxl(InputStream inputStream, Map<String, String> fieldMap) throws IOException {
        List<HashMap<String, Object>> maps = new ArrayList();
        try {
            //读取文件要getWorkbook
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(0);
            HashMap<String, Object> map = null;
            //第一行是标题，第二行是列标题，没有数据，所有默认从第3行开始读
            for (int i = 2; i < sheet.getRows(); i++) {
                map = new HashMap<>();
                for (int j = 0; j < sheet.getColumns(); j++) {
                    map.put(fieldMap.get(sheet.getCell(j, 1).getContents()), sheet.getCell(j, i).getContents());
                }
                maps.add(map);
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return maps;
    }


}
