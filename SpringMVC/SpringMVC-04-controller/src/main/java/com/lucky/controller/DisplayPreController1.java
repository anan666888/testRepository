package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class DisplayPreController1 {
    //访问路径：http://localhost:8080/controller/displayPreTest1?userName=displayPreTest1
    @RequestMapping("/displayPreTest1")
    public String DisplayPreTest1(@RequestParam("userName") String name, ModelMap model){
        model.addAttribute("msg",name);
        System.out.println(name);
        return "test";
    }
    //访问路径：http://localhost:8080/controller/displayPreTest2?userName=displayPreTest2
    @RequestMapping("/displayPreTest2")
    public String DisplayPreTest2(@RequestParam("userName") String name, Model model){
        model.addAttribute("msg",name);
        System.out.println(name);
        return "hello";
    }
}
