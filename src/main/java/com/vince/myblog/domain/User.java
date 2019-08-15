package com.vince.myblog.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    //用户名
    private String username;

    private String password;

    private String name;
}