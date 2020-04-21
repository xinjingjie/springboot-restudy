package com.xinjingjie.restudy.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:resources.properties")
@ConfigurationProperties(prefix = "face")
public class Face {
    private String eye;
    private String nose;
    private String mouth;
//ApplicationContext
    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    @Override
    public String toString() {
        return "Face{" +
                "eye='" + eye + '\'' +
                ", nose='" + nose + '\'' +
                ", mouth='" + mouth + '\'' +
                '}';
    }

}
