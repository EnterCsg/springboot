package com.example.springboot01.service.impl;

import com.example.springboot01.domain.User;
import com.example.springboot01.mapper.UserMapper;
import com.example.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }
}
