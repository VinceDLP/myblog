package com.vince.myblog.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: myblog
 * @author: Dong Ping
 * @description:: 简单实现json
 * @create: 2019-08-16 15:13
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        this.put((String) "code", 0);
        this.put((String) "msg", "success");
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put((String) "code", code);
        r.put((String) "msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put((String) "msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
