package com.example.demo;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTest {

    @Test //
    public void test3() {
        String a=Integer.toBinaryString(5);
        System.out.println(a.length()-a.replace("1", "").length());
    }


    /**
     * @Description:取近似数 //给出一个随机的数，去除重复的数字后，判断 剩余的数首位是否可以被末位整除
     * //例如 Integer num = 56668447844 原数字
     * //去除重复的数字后 57 （如果去除重复的数后剩余 一位数，则首位和末尾都为该数，如果一位都不剩，则为null）
     * //判断 剩余的数首位是否可以被末位整除
     * @Param: []
     * @Author: gengyuzhong
     * @Date: 2019/10/30
     */
    @Test
    public void test2() {
        String str = "156156456";
        Matcher m = Pattern.compile("(\\d)(?=.*\\1)").matcher(str);
        //()捕获型数组，(?=)非捕获性数组， *匹配前面的0次或者多次，\1捕获型数组拿到的值
        while (m.find()){
            str = str.replace(m.group(), "");
        }
        try {
            System.out.println(Integer.parseInt(str.toCharArray()[0] + "") % Integer.parseInt(str.toCharArray()[str.length() - 1] + "") == 0);
        } catch (Exception e) {
            System.out.println(false);
        }
    }

    /**
     * @Description:取近似数
     * @Param: []
     * @Author: gengyuzhong
     * @Date: 2019/10/25
     */
    @Test
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        BigDecimal bigDecimal = new BigDecimal(scanner.nextFloat());
        System.out.println(bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP).longValue());
    }


}
