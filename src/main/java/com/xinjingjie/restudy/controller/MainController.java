package com.xinjingjie.restudy.controller;

import com.xinjingjie.restudy.exception.UserNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String index(){
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
        return "i";
    }
    @RequestMapping("/s")
    public ResponseEntity<Map<String, Object>> error1(HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("not null","For Test");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @RequestMapping(value = "/s",produces = MediaType.TEXT_HTML_VALUE)
    public String error2() {
        System.out.println("MainController.error2");
        return "i";
    }

    @RequestMapping("/user")
    public String needParam(@RequestParam("u") String user) {
    if ("aaa".equals(user)){
//        throw new RuntimeException("用户不存在");
        throw new UserNotExistException();
    }return "index";

    }
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//
//    }
}
