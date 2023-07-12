package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("userList", Arrays.asList("liwanyu","zhangsan"));
        model.addAttribute("msg","<h1>hello,world!!!<h1>");
        return "welcome";
    }
}
