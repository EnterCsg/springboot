package com.example.springboot01.service;

import com.example.springboot01.domain.User;

public interface UserService {

    public User selectUserById(Long id);

    User selectUserById2(Long id);
}
