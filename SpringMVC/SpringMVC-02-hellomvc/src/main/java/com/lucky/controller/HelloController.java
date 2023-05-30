package com.lucky.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //ModelAndView：模型和视图
        ModelAndView mv = new ModelAndView();
        String result = "helloSpring!";
        //封装对象：放在ModelAndView中
        mv.addObject("msg",result);//业务代码
        //封装视图：放在ModelAndView中
        mv.setViewName("test");//试图跳转
        return mv;
    }
}
