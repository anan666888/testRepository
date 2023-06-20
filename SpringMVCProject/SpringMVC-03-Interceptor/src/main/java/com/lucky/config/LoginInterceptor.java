package com.lucky.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果访问路径中含有“login”，那么是登陆页面则放行
        System.out.println("URI:"+request.getRequestURI());
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        //如果session中用户已经被保存，说明已登录则放行
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            return true;
        }
        /**用户没有登录并且访问的不是登录页面，
         * 那么系统要跳转到登录页面登录后才可进行其他操作*/
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
