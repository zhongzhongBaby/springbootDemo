package com.example.demo;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import com.example.demo.entity.request.RequestBase;
import com.example.demo.enums.ReqSource;
import com.example.demo.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.Request;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public final class MyTest {

    AtomicInteger atomicInteger = new AtomicInteger();
    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        while (scanner.hasNextLine()) {
            String a[] = scanner.nextLine().split(":");
            if (a.length == 2) {
                result += "\"" + a[0] + "\":" + a[1] + ",\n";
            } else {
                break;
            }
        }
        System.out.println(result);
    }


    //加引号
    @Test
    public void test2() {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        StringBuilder a = new StringBuilder();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("=")) break;
            a.append(s.split(",")[0].replaceAll("\\(", "").replaceAll("'", "")+"\n");
        }
        System.out.println(a);
    }


    @Test
    public void test3() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String result = "";
        StringBuilder a = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("end")) break;
            if (s.equals("")) continue;
            a.append("'" + s + "',");
            i++;
        }
        System.out.println(a);
        System.out.println(i);
    }


    @Test
    public void test333() {
        String result = "220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c,,220c74fcd5d743efb7b498725d7dc03d,c6e287ba3c29412b85bb7e7a7c94e012,cffed2207ac44f359ba6db60693d1369,,5c94bac6d9e04f90b831a51788bba910,307e4b8278c64e7ea1fbfc53973e37ac,d8943138ca424ab6992b187859c011ee,55ad61397b004656b6c7ab9eebf519d9,329d0b3eef004870a65652fabba53c84,73e859e070bd4c97a2824c6ec14ee8ce,feac4592273d4ce3ad9b77d206490a70,c5ee6ebdef7b432a966647ef970ead1e,1ee80ca93122461dafbb604e813c3189,eace9c565dd34b6da576a5d6dec59b3f,b5878b60cdf94acb94b76e0ce774e77e,b05e0bf4299b473ba1bfc58abbce540c";
        Arrays.stream(result.split(",")).forEach(c -> System.out.print("'" + c + "',"));
    }


    @Test
    public void test33() {
        FileOutputStream fileOutputStream = null;
        File file = new File("G://ids.txt");
        File file2 = new File("G://ids2.txt");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String result = "";
        StringBuilder a = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file2);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer sb = new StringBuffer();
            String text = null;
            while ((text = bufferedReader.readLine()) != null) {
                sb.append("'" + text + "',");
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(sb.toString().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 修改未签到为签到
     */
    @Test
    public void test4() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String result = "";
        StringBuilder a = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("end")) break;
            if (s.equals("")) continue;
            String[] haha = s.split("\t");
            if (haha.length < 5) {
                System.out.println(haha[0] + haha[1]);
                System.out.println(i);
                i++;
                continue;
            }
            haha[0] = haha[0].trim();
            haha[3] = haha[3].replaceFirst("九年级", "初中三年级");
            String[] times = haha[4].split("&");

            for (String time : times) {
                a.append("select sac.id from  student_attend_class sac  " +
                        "left join signuporder so on so.id = sac.order_id " +
                        "left join attend_class ac on ac.id = sac.attend_class_id left join pxxclass pc on pc.id = ac.class_id " +
                        "left join admin_organ ao on ao.id = pc.admin_organ_id " +
                        "left join student s on s.id = so.student_id " +
                        "where s.name = '" + haha[1] + "' and s.mobile = '" + haha[2] + "'  " +
                        "and ao.name = '" + haha[0] + "' and pc.class_name = '" + haha[3] + "'" +
                        "and sac.class_sequence = '" + time + "' and whether_attend = '1'  and roll_call_status = '1' union all \n");
            }
            i++;
        }
        System.out.println(a);
        System.out.println(i);
    }


    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String result = "";
        StringBuilder a = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("end")) break;
            if (s.equals("")) continue;
            String[] haha = s.split("\t");
            a.append("select name,no,(select ps.id from public_school  ps left join city c on c.id = ps.city_id where school_name = '"+haha[4]+"' and FIND_IN_SET('1523',c.parent_ids)) as school from student where name = '"+haha[0]+"' and  no  = '"+haha[1].trim()+"' union all \n");
            i++;
        }
        System.out.println(a);
        System.out.println(i);
    }



    /** 
    * @Description: 学校是否存在 
    * @Param: []
    * @Author: gengyuzhong
    * @Date: 2020/12/19 
    */ 
    @Test
    public void test6() {
        String cityId = "1523";
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String result = "";
        StringBuilder a = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            try {
                if (s.equals("end")) break;
                if (s.equals("")) continue;
                String[] haha = s.split("\t");
                a.append("select if((select ps.id from public_school  ps left join city c on c.id = ps.city_id where school_name = '"+haha[4].trim()+"' and FIND_IN_SET('"+cityId+"',c.parent_ids) limit 1 ) is null ,0,1) union all \n");
                i++;
            } catch (Exception e) {
                System.out.println("++++++++++++++++++++++++++"+s);
            }
        }
        System.out.println(a);
        System.out.println(i);
    }


    /** 
    * @Description: 批量更新学生学校
    * @Param: []
    * @Author: gengyuzhong
    * @Date: 2020/12/19 
    */ 
    @Test
    public void test7() {
        String cityId=  "1523";
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String result = "";
        StringBuilder a = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("end")) break;
            if (s.equals("")) continue;
            String[] haha = s.split("\t");
            String field = "old_attend_class_id";
            if(haha[3].equals("小学部")){
                field = "old_attend_class_id";
            }
            if(haha[3].equals("初中部")){
                field = "old_attend_class_id_middle";
            }
            if(haha[3].equals("高中部")){
                field = "old_attend_class_id_high";
            }
            a.append("update student set "+field+" = ifnull((select ps.id from public_school  ps left join city c on c.id = ps.city_id where school_name = '"+haha[4]+"' and FIND_IN_SET('"+cityId+"',c.parent_ids) and ps.del_flag = FALSE  limit 1 ),"+field+") where name =  '"+haha[0]+"' and  no = '"+haha[1].trim()+"';\n");
            i++;
        }
        System.out.println(a);
        System.out.println(i);
    }
    


  














}


