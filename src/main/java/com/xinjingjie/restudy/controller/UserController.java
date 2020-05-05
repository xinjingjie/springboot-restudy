package com.xinjingjie.restudy.controller;

import com.xinjingjie.restudy.bean.User;
import com.xinjingjie.restudy.mapper.UserMapper;
import com.xinjingjie.restudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@RestController("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findUser")
    public User getUser(int id){
        return userService.getUser(id);
    }

    @GetMapping("/all")
    public String AllUser(){
       return "allUser";
    }

    @GetMapping("/user/{index}")
    public String goUser(@PathVariable("index") String index){
        return "user/"+index;
    }
    @GetMapping("/admin/{index}")
    public String goAdmin(@PathVariable("index") String index){
        return "admin/"+index;
    }
    @GetMapping("/visitor/{index}")
    public String goSuperAdmin(@PathVariable("index") String index){
        return "visitor/"+index;
    }
    @GetMapping("/loginUser")
    public String loginUser(){
        return "login";
    }
}
