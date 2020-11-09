package com.differ.zxl.designpattern.proxypattern;


import java.lang.reflect.Proxy;

public class MyProxy {

    public static void main(String[] args) {

        //这种是把接口的方法具体实现，写在了实现该接口的类中，代理类中依赖该实现类，进行方法代理（就是用一个实现类来代理处理，InvocationHandler中只需要执行方法调用）
        Original original = new Original();
        OriginBase proxyObj = (OriginBase) Proxy.newProxyInstance(original.getClass().getClassLoader(),original.getClass().getInterfaces(),new MyProxyInvocationHandle(original));
        System.out.println(proxyObj);//会调用toString()方法，处理器中调用了原对象的方法并返回，即返回了原对象的地址
        proxyObj.printBase();

        //这种是不需要代理接口的实现类，适用于接口方法在InvocationHandler中的统一处理（如mybatis中dao层，代理接口对数据库增删改查）
        System.out.println("======2222======");
        OriginBase proxyObj2 = (OriginBase) Proxy.newProxyInstance(OriginBase.class.getClassLoader(),new Class[]{OriginBase.class},new MyProxyInvocationHandle());
        proxyObj2.printBase();

    }

}
