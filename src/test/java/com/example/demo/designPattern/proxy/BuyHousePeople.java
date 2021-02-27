package com.example.demo.designPattern.proxy;

public class BuyHousePeople implements BuyHouse, proxy.SellHouse {
    @Override
    public void buyHouse() {
        System.out.println("我要买新房子");
    }
    @Override
    public void sellHouse() {
        System.out.println("我要卖掉老房子");
    }
}
