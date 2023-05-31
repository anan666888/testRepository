package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//@RequestMapping("HelloController2")
public class HelloController2 {
    @RequestMapping("/index")
    public String index(Model model) {
        //Springmvc会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg","HelloController2");
        return "test";//返回视图位置
    }

}
