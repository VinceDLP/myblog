package com.vince.myblog.controller;

import com.vince.myblog.domain.User;
import com.vince.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: myblog
 * @author: Dong Ping
 * @description::
 * @create: 2019-08-15 15:15
 */
@RestController
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public User login(){
        return userService.selectUserById();
    }
}
