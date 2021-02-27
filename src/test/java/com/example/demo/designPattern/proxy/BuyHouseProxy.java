package com.example.demo.designPattern.proxy;

public class BuyHouseProxy implements BuyHouse {

    private BuyHouse buyHouse; //需要代理的服务

    public BuyHouseProxy(final BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }
    @Override
    public void buyHouse() {
        System.out.println("提前准备");
        buyHouse.buyHouse();
        System.out.println("签订合同");
    }
    //为什么要叫静态代理，因为还没有人调用我的时候 我就知道我能代理什么服务。
    //如果现在买房的人也实现了买房的接口，那么也需要为卖房这个服务类写一个代理类。动态代理的话，就不要了，可以直接调用。


}