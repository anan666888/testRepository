package com.lucky.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果是登陆页面则放行
        System.out.println("URI:"+request.getRequestURI());
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        //如果用户已经登录则放行
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            return true;
        }
        //用户没有登录跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
