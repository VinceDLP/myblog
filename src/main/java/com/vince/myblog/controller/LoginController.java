package com.vince.myblog.controller;

import com.vince.myblog.domain.User;
import com.vince.myblog.service.UserService;
import com.vince.myblog.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: myblog
 * @author: Dong Ping
 * @description:
 * @create: 2019-08-15 15:15
 */
@RestController
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private UserService userService;
    @ApiOperation("登陆")
    @RequestMapping("/login")
    public R login(@ApiParam("用户ID") @RequestParam("id") Integer id){
        User user = userService.selectUserById(id);
        return R.ok().put("user",user);
    }
}
