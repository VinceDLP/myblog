package com.vince.myblog.service.impl;

import com.vince.myblog.dao.UserMapper;
import com.vince.myblog.domain.User;
import com.vince.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: myblog
 * @author: Dong Ping
 * @description::
 * @create: 2019-08-15 15:12
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectUserById() {
        return userMapper.selectByPrimaryKey(1);
    }
}
