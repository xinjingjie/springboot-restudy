package com.xinjingjie.restudy.controller;

import com.xinjingjie.restudy.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
    public String handleException(Exception e,HttpServletRequest request){
        Map<String,Object> mp=new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);

        mp.put("code",555);
        mp.put("message","没有找到用户");
        request.setAttribute("ext",mp);
        return "forward:/error";
    }
}
