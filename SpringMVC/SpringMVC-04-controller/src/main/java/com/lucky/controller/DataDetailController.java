package com.lucky.controller;

import com.lucky.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataDetailController {
    //访问路径：http://localhost:8080/controller/test1?name=test2
    @RequestMapping("/test1")
    public String test1(String name){
        System.out.println(name);
        return "test";
    }
    //访问路径：http://localhost:8080/controller/test2?username=test2
    @RequestMapping("/test2")
    public String test2(@RequestParam("username") String name){
        System.out.println(name);
        return "hello";
    }

    @RequestMapping("/userTest")
    public String userTest(User user){
        System.out.println(user);
        return "hello";
    }
}
