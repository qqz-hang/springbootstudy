package com.atguigu.springboot.exception;

public class LoginNotExistsException extends RuntimeException {
    public LoginNotExistsException() {
        super("用户出错啦");
    }
}
