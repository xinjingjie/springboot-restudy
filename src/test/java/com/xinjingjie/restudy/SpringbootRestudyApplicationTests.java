package com.xinjingjie.restudy;

import com.sun.mail.smtp.SMTPMessage;
import com.xinjingjie.restudy.bean.Face;
import com.xinjingjie.restudy.bean.Person;
import com.xinjingjie.restudy.bean.User;
import com.xinjingjie.restudy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootRestudyApplicationTests {

//    @Autowired
//    Person person;
//
//    @Autowired
//    Face face;
    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void sendEmail(){
//        SimpleMailMessage simpleMailMessage=new
//                SimpleMailMessage();
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("1090282309@qq.com");
            helper.setSubject("测试");
            helper.setText("<b style='color:blue'>这是用springboot发送的邮件</b>",true);
            helper.setTo("925045176@qq.com");
            helper.addAttachment("suzhouhe.jpg",new File("C:\\Users\\10902\\Pictures\\p1401219611.jpg"));
            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Test
    void contextLoads() throws SQLException {

        User user = userMapper.findUser(1);
        System.out.println(user);
    }
    @Test
    void test1(){
        stringRedisTemplate.opsForValue().append("msg","nmsl");
    }
    @Test
    void test2(){
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    void test3(){
        User user = userMapper.findUser(1);
        //redisTemplate.opsForSet().add("currentUser",user);
        redisTemplate.opsForValue().set("currentUser",user);
    }
    @Test
    void test4(){
        User user = (User) redisTemplate.opsForValue().get("currentUser");
        System.out.println(user);
    }

}
