package com.lucky.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController：注解的作用是方法可以直接返回一个字符串，而非是jsp页面的名字
@RestController
public class AjaxController {
    @RequestMapping("/test1")
    public String test(){
        return "hello";
    }
}
