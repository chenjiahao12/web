package com.cjh.demo.service.impl;

import com.cjh.demo.mapper.UserMapper;
import com.cjh.demo.model.User;
import com.cjh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-11 14:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
