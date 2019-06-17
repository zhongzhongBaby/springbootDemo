package com.example.demo;

import org.junit.Test;

public class StringTest {



    /** 
    * @Description: 交换字母的顺序，非字母字符保留在原来的位置 
    * @Param: []
    * @Author: gengyuzhong
    * @Date: 2019/6/17 
    */ 
    @Test
    public void testOne() throws Exception {
        String a = "a-bc-====d=ef----ghij!";
        char[] b = a.toCharArray();
        int i = 0, j = b.length - 1;
        while (i < j) {
            if ('a' <= b[i] && b[i] <= 'z') {
                if ('a' <= b[j] && b[j] <= 'z') {
                    char temp=b[i];
                    b[i++]=b[j];
                    b[j--]=temp;
                }else{
                    j--;
                }
            } else {
                i++;
            }
        }
        for(int k=0;k<b.length;k++){
            System.out.print(b[k]);
        }
    }



}
