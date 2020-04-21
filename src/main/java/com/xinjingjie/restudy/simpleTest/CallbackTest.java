package com.xinjingjie.restudy.simpleTest;

public class CallbackTest {
   static NotAchieve notAchieve;

    public static void main(String[] args) {
//        Achieve a=new Achieve();
//        a.sayHello();
        SimpleTest simpleTest= (SimpleTest) new Achieve();
        simpleTest.sayYes();
    }
}
