package com.atguigu.springboot.commpont;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录处理程序拦截器
 *
 * @author 76109
 * @date 2021/11/01
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // return HandlerInterceptor.super.preHandle(request, response, handler);
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            // 登录成功
            return true;
        }
        request.setAttribute("msg", "没有权限，请先登录");
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //  HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //  HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
