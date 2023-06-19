package com.lucky.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {
    @RequestMapping("/test1")
    public String test1(){
        System.out.println("测试方法通过打印");
        return "okok!";
    }
}
