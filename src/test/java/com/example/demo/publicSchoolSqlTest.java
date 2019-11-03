package com.example.demo;

import org.junit.Test;

import java.util.Scanner;

public class publicSchoolSqlTest {

    //批量修改学校的代码

    @Test
    public void test3() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result= new StringBuilder();
        while (scanner.hasNextLine()) {
            String[] info = scanner.nextLine().split(" ");
            if(info.length!=7){
                System.out.println(info[0]);
                break;
            }
            if(info.equals("end")){
                break;
            }
            String field ="";
            if((!info[6].equals("1"))||(!info[3].equals("1"))){  //排除歧义数据
                continue;
            }
            if(info[5].split(",").length==1){
                if(info[5].equals("1")){
                    field="old_attend_class_id";
                }else if(info[5].equals("2")){
                    field="old_attend_class_id_middle";
                }else if(info[5].equals("3")){
                    field="old_attend_class_id_high";
                }
            }else{//学部多个时根据年级设定
                Integer grade=Integer.parseInt(info[2]);
                if(grade<7){
                    field="old_attend_class_id";
                }else if(grade<10){
                    field="old_attend_class_id_middle";
                }else if(grade<13){
                    field="old_attend_class_id_high";
                }
            }
            String sql = "update student set "+field+" = (select id from public_school where school_name ='"+info[4]+"' and del_flag = false ) where  name ='"+info[0]+"'  and  no ='"+info[1]+"'; \n";
            result.append(sql);
        }
        System.out.println(result.toString());
    }


    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result= new StringBuilder();
        while (scanner.hasNextLine()) {
            String info = scanner.nextLine();
            if(info.equals("end")){
                break;
            }
            String sql = "SELECT  DISTINCT school_name,IFNULL(department_type,0) ,count(*) FROM `public_school` where " +
                    "del_flag =false " +
                    "and school_name ='" + info +"'"+"\n" +
                    "union all ";
            result.append(sql);
        }
        System.out.println(result.toString());
    }


    @Test
    public void test2() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result= new StringBuilder();
        while (scanner.hasNextLine()) {
            String[] info = scanner.nextLine().split(" ");
            if(info.length!=2){
                break;
            }
            if(info.equals("end")){
                break;
            }
            String sql = "select  DISTINCT name, grade, count(*) from student where name ='"+info[0]+"' and no ='"+info[1]+"' and del_flag =false\n"+"union all ";
            result.append(sql);
        }
        System.out.println(result.toString());
    }





}







