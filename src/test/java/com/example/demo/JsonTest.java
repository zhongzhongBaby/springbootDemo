package com.example.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonTest {


    /**
     * @Description: 转json
     * @Param:
     * @Date: 2020/1/14
     */
    @Test
    public void test14() {
        Scanner scanner = new Scanner(System.in);
        List<String> c = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            if (a.equals("end")) break;
            String[] as = a.split(":");
            if (as.length > 1) {
                String b = "\"" + as[0] + "\":" + as[1] + ",";
                c.add(b);
            }
        }
        c.forEach(System.out::println);
    }


}
