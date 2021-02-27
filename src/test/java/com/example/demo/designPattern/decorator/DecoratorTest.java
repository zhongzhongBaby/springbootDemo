package com.example.demo.designPattern.decorator;

public class DecoratorTest {

    public static void main(String[] args){
        Drink drink =  new MilkyTea();
        System.out.println("名称:"+drink.getName());
        System.out.println("价格:"+drink.getPrice());
        SugarDecorator sugerDecorator =  new SugarDecorator(drink);
        sugerDecorator.addSugar();
    }

}
