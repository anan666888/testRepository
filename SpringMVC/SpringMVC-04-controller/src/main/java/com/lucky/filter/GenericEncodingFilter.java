package com.lucky.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GenericEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //处理response的字符编码
        HttpServletResponse myResponse = (HttpServletResponse) response;
        myResponse.setContentType("text/html;charset=UTF-8");
        //转型为与协议相关对象
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //对request包装增强
        MyRequest myRequest = new MyRequest(httpServletRequest);
        chain.doFilter(myRequest,response);
    }

    @Override
    public void destroy() {

    }
}
