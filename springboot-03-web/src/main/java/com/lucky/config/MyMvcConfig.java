package com.lucky.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//如果你想diy一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配
//扩展springMVC   dispatchServlet
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //viewResolver实现了视图解析器接口的类，我们就可以把他看做视图解析器
    @Bean
    public ViewResolver myViewResolver(){
        System.out.println("333");
        return new MyViewResolver();
    }

    //自定义一个自己的视图解析器MyViewResolver
    public static class MyViewResolver implements ViewResolver, InitializingBean {

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            System.out.println("222");
            return null;
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("111");
        }
    }
}
