package com.xinjingjie.restudy.simpleTest;

public class Achieve implements NotAchieve{
    public static int i=2;
    public Achieve() {
        System.out.println("子类的构造函数");
    }

    public static void sayHello() {
        System.out.println("子类的静态函数"+i);
    }

    @Override
    public void sayYes() {
        System.out.println("SayYes!");
    }
}
