package com.xinjingjie.restudy.simpleTest;

public interface NotAchieve {
    public static int i=1;
    public static void sayHello() {
        System.out.println("父类的静态函数"+i);
    }

    public void sayYes();
}
