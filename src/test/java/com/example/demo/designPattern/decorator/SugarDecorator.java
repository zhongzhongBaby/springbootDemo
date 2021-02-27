package com.example.demo.designPattern.decorator;

public class SugarDecorator extends DrinkDecorator{
    public SugarDecorator(Drink drink) {
        super(drink);
    }
    @Override
    public String getName() {
        return super.drink.getName();
    }

    @Override
    public Integer getPrice() {
        return super.drink.getPrice();
    }

    public void addSugar() {
        System.out.println("装饰:我往"+super.drink.getName()+"里加了好多的糖");
    }



    //如果是通过继承实现加糖，那是不是得分别为咖啡和奶茶生成加糖子类。 那有人说了，为什么不直接在Coffee类里面添加加糖方法呢。
    //那如果出现其他的业务场景呢，有的coffee可以加糖，有的不可以呢。是不是直接在Coffee类里面添加方法就不合适了，所以还是得生成子类
    //但是如果生成子类，有必须为所有的饮料实现类，同时生成子类。这就造成了子类膨胀。

    //2.加糖这个修饰方法，具体修饰的是哪种饮料，在编写代码的时候的是不知道的，所以可以理解为动态的。

    //还可以有打折装饰器



}
