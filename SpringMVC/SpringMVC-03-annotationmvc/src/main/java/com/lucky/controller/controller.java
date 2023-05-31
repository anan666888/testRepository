package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class controller {
    //真实访问地址：项目名/HelloController/hello
    @RequestMapping("/h1")
    public String sayHello(Model model){
        //向模型中添加属性msg与值，可以在jsp页面中取出并渲染
        model.addAttribute("msg","hello Springmvc");
        //WEB-INF/jsp/hello.jsp
        return "hello";
    }
}
