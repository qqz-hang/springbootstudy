package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.LoginNotExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhang", "li", "wang"));
        return "success";
    }
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if ("aaa".equals(user)) {
            throw new LoginNotExistsException();
        }
        return "hello world";
    }
}
