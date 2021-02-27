package com.example.demo.designPattern.decorator;

public class MilkyTea  implements Drink{

    @Override
    public String getName() {
        return "奶茶";
    }

    @Override
    public Integer getPrice() {
        return 10;
    }

}
