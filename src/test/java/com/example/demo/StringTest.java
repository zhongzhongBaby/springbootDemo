package com.example.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    /**
     * @Description: 下划线转驼峰形式
     * @Param: []
     * @Author: gengyuzhong
     * @Date: 2020/1/2
     */
    @Test
    public  void test8(){
        String a = "create_date";
        Matcher m = Pattern.compile("_([a-z])").matcher(a);
        while(m.find()){
            System.out.println(m.group(0));
            a=a.replaceFirst(m.group(0), m.group(1).toUpperCase());
        }
        System.out.println(a);
    }



    /**
    /**
     * @Description:
     */
    @Test
    public void test7() {
        System.out.println(StringTest.class.getResource("/"));
        System.out.println(StringTest.class.getResource(""));
        System.out.println(StringTest.class.getClassLoader().getResource("/"));
        System.out.println(StringTest.class.getClassLoader().getResource(""));
    }


    /**
     * @Description: 合数转质数乘积
     */
    @Test
    public void test6() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String a =  scanner.nextLine().substring(2);
            Integer b = Integer.parseInt(a, 16);
            System.out.println(b);
        }
    }

    /**
     * @Description: 十六进制转十进制   0xA
     */
    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String a =  scanner.nextLine().substring(2);
            Integer b = Integer.parseInt(a, 16);
            System.out.println(b);
        }
    }



    /**
     * @Description: 字符串按照位数分割加补充
     */
    @Test
    public void test4() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String a = scanner.nextLine();
            while (a.length() > 8) {
                String b = a.substring(0, 8);
                result.add(b);
                a = a.substring(8, a.length());
            }
            int temp = a.length();
            for (int j = 0; j < (8 - temp); j++) {
                a = a + "0";
            }
            result.add(a);
        }
        result.forEach(System.out::println);
    }


    /**
     * @Description: 数字缺失问题  二分法解决
     * @Param: []
     * @Author: gengyuzhong
     * @Date: 2019/6/17
     */
    @Test
    public void test3() throws Exception {
        int size = 50000000 - 1;
        int[] a = new int[size];
        int m = (int) (Math.random() * size); //遗漏的数
        for (int k = 0; k < size; k++) {
            if (k < m - 1) {
                a[k] = k + 1;
            } else {
                a[k] = k + 2;
            }
        }
        //int[] a = {1, 2, 4, 5, 6, 7, 8, 9, 10,11 };
        Date date = new Date();
        int i = 0, j = a.length - 1, mid = 0;
        //二分法查找
        while (i < j) {
            mid = (i + j) / 2;
            if (a[mid] == (mid + 1)) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int ans = a[i] == (i + 1) ? i + 2 : i + 1; // i只会逼近到第一个开始错误的数上或者第一个开始错误的数前一位
        System.out.println("遗漏：" + ans);
        System.out.println("用时：" + (new Date().getTime() - date.getTime()));
        System.out.println("正确与否：" + (ans == m));
    }


    /**
     * @Description: 查找使括号完全闭合的所有括号
     * @Param: []
     * @Author: gengyuzhong
     * @Date: 2019/6/17
     */
    @Test
    public void testTwo() throws Exception {
        //时间复杂度o(n) 准确的说是2n 但是代码量长
        char[] a = "((()((()))()))(()())((((())))))()))))))))()))()))(())(((((((())()()()())((())))))))()((()()()()))))(())()(())(((())((())(()()()()()((((((((()))))())))))()))))))))))))))))()()()(()()()()()()()".toCharArray();
        int ans = a.length, length = ans;
        for (int i = 0, j = 0; i < length && j < length; ) {
            if (a[i] != '(') {
                i++;
                continue;
            } else {
                j = i > j ? i : j; //j保证比i大
                if (a[j] == ')') {
                    ans = ans - 2;
                    i++;
                }
                j++;
            }
        }
        System.out.println(ans);
    }


    /**
     * @Description: 交换字母的顺序，非字母字符保留在原来的位置
     * @Param: []
     * @Author: gengyuzhong
     * @Date: 2019/6/17
     */
    @Test
    public void testOne() throws Exception {
        String a = "c==ab-a=-b!&a==ab-a=";
        char[] b = a.toCharArray();
        int i = 0, j = b.length - 1;
        while (i < j) {
            if ('a' <= b[i] && b[i] <= 'z') {
                if ('a' <= b[j] && b[j] <= 'z') {
                    char temp = b[i];
                    b[i++] = b[j];
                    b[j--] = temp;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        for (int k = 0; k < b.length; k++) {
            System.out.print(b[k]);
        }
    }


}
