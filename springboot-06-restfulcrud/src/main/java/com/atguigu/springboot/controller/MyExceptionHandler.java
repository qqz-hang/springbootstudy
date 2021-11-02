package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.LoginNotExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

// 处理异常
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 自适应效果
     *
     * @param e
     * @return
     */
    @ExceptionHandler(LoginNotExistsException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user not exists");
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
        return "forward:/error";
    }
}
