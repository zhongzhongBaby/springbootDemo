package com.example.demo.designPattern.decorator;


public  abstract  class DrinkDecorator implements  Drink{
    protected  Drink drink;
    public DrinkDecorator(Drink drink) {
        this.drink = drink;
    }
}


