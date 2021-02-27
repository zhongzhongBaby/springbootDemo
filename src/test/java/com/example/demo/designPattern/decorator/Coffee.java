package com.example.demo.designPattern.decorator;

public class Coffee implements Drink {

    @Override
    public String getName() {
        return "咖啡";
    }

    @Override
    public Integer getPrice() {
        return 100;
    }
}
