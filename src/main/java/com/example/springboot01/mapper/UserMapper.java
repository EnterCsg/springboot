package com.example.springboot01.mapper;

import com.example.springboot01.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    public User selectUserById(Long id);

    @Select("select * from test_user where id = #{id}")
    User selectUserById2(Long id);
}
