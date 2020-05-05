package com.xinjingjie.restudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@MapperScan("com.xinjingjie.restudy.mapper")
@ServletComponentScan
public class SpringbootRestudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestudyApplication.class, args);
    }

}
