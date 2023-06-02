package com.lucky.controller;

import org.hamcrest.core.SubstringMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {
    @RequestMapping("/encodingTest")
    public String encodingTest(Model model,String name){
        model.addAttribute("msg",name);//获取表单提交的值
        return "test";//跳转到test页面显示输入的值
    }
}
