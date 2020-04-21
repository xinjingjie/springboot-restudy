package com.xinjingjie.restudy;

import com.xinjingjie.restudy.bean.Face;
import com.xinjingjie.restudy.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRestudyApplicationTests {

    @Autowired
    Person person;

    @Autowired
    Face face;
    @Test
    void contextLoads() {
        System.out.println(person);
        System.out.println(face);
    }

}
