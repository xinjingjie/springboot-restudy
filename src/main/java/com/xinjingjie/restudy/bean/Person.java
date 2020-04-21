package com.xinjingjie.restudy.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
//@ConfigurationProperties(prefix = "person")
public class Person {
    @Value("${person.name}")
    private String name;
    private int age;
    private List hand;
    private Face face;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getHand() {
        return hand;
    }

    public void setHand(List hand) {
        this.hand = hand;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hand=" + hand +
                ", face=" + face +
                '}';
    }
}
