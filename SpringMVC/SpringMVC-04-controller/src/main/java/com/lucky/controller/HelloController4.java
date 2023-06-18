package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController4 {
    @RequestMapping("/result/t1")
    public void test1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Hello,Spring by servlet API");
    }
    @RequestMapping("/result/t2")
    public void test2(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //重定向
        resp.sendRedirect("/test.jsp");
    }
    @RequestMapping("/result/t3")
    public void test3(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //转发
        req.setAttribute("msg","/result/t3");
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,resp);
    }
}
