package com.lucky.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {
    public static String getJson(Object obj){
        return getJson(obj,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object obj,String dateFormate){
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间差的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //自定义日期时间对象
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
        mapper.setDateFormat(sdf);
        String str = null;
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
