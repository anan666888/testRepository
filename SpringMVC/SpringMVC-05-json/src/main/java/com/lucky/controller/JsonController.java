package com.lucky.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lucky.pojo.User;
import com.lucky.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class JsonController {
    /**@ResponseBody的作用:
     * 将controller的方法返回的对象通过适当的转化器转换为指定格式之后，
     * 写入到response对象的body区，通常用来返回JSON数据或者是xml数据。
     */
    @RequestMapping(value = "/json1")
    public String json1() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("姓名1", "女", 13);
        //将我们的对象解析成json格式
        String str = mapper.writeValueAsString(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个list对象
        User user1 = new User("张三", "男", 13);
        User user2 = new User("里斯", "女", 1);
        User user3 = new User("汪芜", "男", 11);
        User user4 = new User("赵六", "男", 11);
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(list);
        return str;
    }
    
    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个时间对象
        Date date = new Date();
        String str = mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);
        Date date = new Date();
        String str = mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping("/json5")
    public String json5() throws JsonProcessingException {
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }
}
