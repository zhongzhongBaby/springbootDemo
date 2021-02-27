package com.example.demo.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyBuyHouseHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyBuyHouseHandler(final Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("提前准备");
        Object result = method.invoke(object, args);
        System.out.println("签订合同");
        return result;
    }
    //为什么要叫动态代理呢，因为我这个中介具体要代理什么服务，我自己都不知道。只有在运行的时候，我才知道，哦原来客户想让我帮他买房子。
}