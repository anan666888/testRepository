package com.lucky.controller;

import com.lucky.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxContrller {

    @RequestMapping("/test1")
    public String test1(){
        return "hello";
    }

    @RequestMapping("/test2")
    public void test2(String name, HttpServletResponse response) throws IOException {
        if ("admin".equals(name)) {
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/test3")
    public List<User> test3(){
        List<User> list = new ArrayList<>();
        list.add(new User(1,"里斯",13,"女"));
        list.add(new User(2,"张三",14,"男"));
        list.add(new User(2,"小明",14,"男"));
        list.add(new User(2,"汪芜",14,"女"));
        list.add(new User(2,"赵六",14,"男"));
        return list;//由于该类使用@RestController注解，所以list会转换成json类型传给前端
    }
}
