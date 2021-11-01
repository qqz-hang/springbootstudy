package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String loginAction(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model,
                              HttpSession session) {
        if (!ObjectUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账户密码不正确");
            return "login";
        }
    }
}
