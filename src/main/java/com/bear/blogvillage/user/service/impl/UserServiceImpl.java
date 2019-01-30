package com.bear.blogvillage.user.service.impl;

import com.bear.blogvillage.user.dao.UserMapper;
import com.bear.blogvillage.user.po.User;
import com.bear.blogvillage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
