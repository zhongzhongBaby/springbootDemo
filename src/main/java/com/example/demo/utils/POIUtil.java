package com.example.demo.utils;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

import java.lang.reflect.Field;

public class POIUtil {

    /**
    * @Description: 重写 merge 方法  解决poi在合并次数过于多时候的性能瓶颈问题
    * @Param: [sheet, region]
    * @Author: gengyuzhong
    * @Date: 2019/6/17
    */
    private void addMergedRegion(SXSSFSheet sheet , CellRangeAddress region) {
        Object value = null;
        Class classTemp  = sheet.getClass();
        // 得到所有属性
        Field[] fields = classTemp.getDeclaredFields();
        if(fields.length > 0){
            // 得到属性
            Field field = fields[0];
            // 打开私有访问
            field.setAccessible(true);
            // 获取属性
            String name = field.getName();
            // 获取属性值
            try{
                value = field.get(sheet);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        CTWorksheet worksheet = ((XSSFSheet)value).getCTWorksheet();
        if (region.getNumberOfCells() < 2) {
            throw new IllegalArgumentException("Merged region " + region.formatAsString() + " must contain 2 or more cells");
        } else {
            region.validate(SpreadsheetVersion.EXCEL2007);
            CTMergeCells ctMergeCells = worksheet.isSetMergeCells() ? worksheet.getMergeCells() : worksheet.addNewMergeCells();
            CTMergeCell ctMergeCell = ctMergeCells.addNewMergeCell();
            ctMergeCell.setRef(region.formatAsString());
        }
    }



}
