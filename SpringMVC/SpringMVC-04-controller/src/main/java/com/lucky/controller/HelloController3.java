package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController3 {
    @RequestMapping("/restfulMethod/{a}/{b}")
    public String restfulMethod(@PathVariable int a, @PathVariable String b, Model model) {
        String res = a + b;
        //Springmvc会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg","helloController3结果：" +res);
        return "test";//返回视图位置
    }

    @RequestMapping(value = "/restfulMethod2",method = RequestMethod.POST)
    public String restfulMethod2(Model model){
        String res = "restfulMethod2属性指定请求类型";
        model.addAttribute("msg",res);
        return "test";
    }

    @RequestMapping(value = "/restfulMethod3",method = RequestMethod.GET)
    public String restfulMethod3(Model model){
        String res = "restfulMethod2属性指定请求类型";
        model.addAttribute("msg",res);
        return "test";
    }
}
