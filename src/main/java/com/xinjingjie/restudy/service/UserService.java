package com.xinjingjie.restudy.service;

import com.xinjingjie.restudy.bean.User;
import com.xinjingjie.restudy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Cacheable(cacheNames = "currentUser",key = "#id",condition = "#id!=0",unless = "#result==null")
    public User getUser(int id){
        System.out.println("查询"+id+"号的信息");
       return userMapper.findUser(id);
    }
    @CachePut(cacheNames = "currentUser",key = "#user.uid")
    public int update(User user){
        return userMapper.updateUse(user);
    }
    @CacheEvict(cacheNames = "currentUser",key = "#id")
    public int delete(int id){
        return userMapper.deleteU(id);
    }
}
