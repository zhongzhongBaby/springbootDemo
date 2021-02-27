package com.example.demo.designPattern.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        BuyHouse buyHousePeople = new BuyHousePeople();
        buyHousePeople.buyHouse();
        System.out.println("=====================");
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHousePeople);
        buyHouseProxy.buyHouse();
    }
}