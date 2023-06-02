package com.lucky.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

//自定义request对象，HttpServletRequest的包装类
public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    //是否编码标记
    private boolean hasEncode;
    //定义一个可以传入HttpServletRequest对象的构造函数，以便对其进行修饰
    public MyRequest(HttpServletRequest request) {
        super(request);//super必须写
        this.request = request;
    }
    //对需要增强方法进行覆盖
    @Override
    public Map getParameterMap(){
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")){
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if(method.equalsIgnoreCase("get")){
            //get请求
            Map<String,String[]> parameterMap = request.getParameterMap();
            if (!hasEncode) {
                for (String parameterName : parameterMap.keySet()) {
                    String[] values = parameterMap.get(parameterName);
                    if (values !=null) {
                        for (int i = 0; i < values.length; i++) {
                            try {//处理get乱码
                                values[i] = new String(values[i].getBytes("ISO-8859-1"),StandardCharsets.UTF_8);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    //取一个值
    @Override
    public String getParameter(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if (values == null) {
            return null;
        }
        return values[0]; // 取回参数的第一个值
    }

    //取所有值
    @Override
    public String[] getParameterValues(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        return values;
    }



}
