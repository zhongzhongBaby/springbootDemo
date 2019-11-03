package com.example.demo;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtherTest {

    /**
     * @Description: 购物单
     * @Param: []
     * @Author: gengyuzhong
     * @Date: 2019/10/31
   */
    @Test
    public void test4() {
        String[] a = {"a", "b", "c", "d", "e", "f"};
        combinationSelect(a,3);
    }
    private static long factorial(int n) {
        long sum = 1;
        while (n > 0) {
            sum = sum * n--;
        }
        return sum;
    }
    private static long combination(int m, int n) {
        return m < n ? factorial(n) / (factorial(n - m) * factorial(m)) : 0;
    }
    public static void combinationSelect(String[] dataList, int n) {
        System.out.println(String.format("C(%d, %d) = %d", dataList.length, n, combination(n, dataList.length)));
        combinationSelect(dataList, 0, new String[n], 0);
    }

    private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            System.out.println(Arrays.asList(resultList));
            return;
        }
        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, dataIndex + 1, resultList, resultIndex + 1);
        }
    }


    /**
     * 正则表达式学习
     *
     * @Author: gengyuzhong
     * @Date: 2019/10/30
     */
    @Test
    public void test3() {
        String str = "11111163232595";
        Matcher m = Pattern.compile("[1-5|7-9]+").matcher(str);
        while (m.find()) {
            System.out.println(m.group());
            str = str.replace(m.group(), "");
        }
        System.out.println(str);
        try {
            System.out.println(Integer.parseInt(str.toCharArray()[0] + "") % Integer.parseInt(str.toCharArray()[str.length() - 1] + "") == 0);
        } catch (Exception e) {
            System.out.println(false);
        }
    }

    @Test
    public void test2() {
        String a = Integer.toBinaryString(5);
        System.out.println(a.length() - a.replace("1", "").length());
    }


    @Test
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        Integer totle = scanner.nextInt();
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < totle; i++) {
            Integer key = scanner.nextInt();
            Integer value = scanner.nextInt();
            result.put(key, result.get(key) != null ? result.get(key) + value : value);
        }
        result.keySet().stream().sorted().forEach(c -> {
            System.out.println(c + " " + result.get(c));
        });
    }


}
