package com.example.springboot01.mapper;

import com.example.springboot01.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User selectUserById(Long id);

}
