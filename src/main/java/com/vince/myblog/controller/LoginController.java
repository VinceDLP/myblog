package com.vince.myblog.controller;

import com.vince.myblog.domain.User;
import com.vince.myblog.service.UserService;
import com.vince.myblog.utils.R;
import com.vince.myblog.utils.VerifyUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;


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
    public R login(@ApiParam("用户ID") @RequestParam("id") Integer id) {
        User user = userService.selectUserById(id);
        return R.ok().put("user", user);
    }

    @ApiOperation("测试验证登陆")
    @PostMapping("/logon")
    public R logon(@ApiParam("用户名") @RequestParam String username, @ApiParam("密码") @RequestParam String password, @ApiParam("验证码") @RequestParam String code, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("imageCode") == null) {
            return R.error("重新获取验证码");
        } else {
            if(session.getAttribute("imageCode").toString().equalsIgnoreCase(code)){
                return R.ok("验证正确");
            }else {
                return R.error("验证码错误");
            }
        }
    }

    @ApiOperation("生成验证码")
    @GetMapping("/getcode")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session
        session.setAttribute("imageCode", objs[0]);

        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }
}
