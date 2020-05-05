package com.xinjingjie.restudy.mapper;

import com.xinjingjie.restudy.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select("Select * from user  where uid=#{uid}")
    public User findUser(int uid);

    @Update("update user set age=#{age} where uid=#{uid}")
    public int updateUse(User user);

    @Delete("Delete * from user where uid=#{uid}")
    public int deleteU(int uid);
}
