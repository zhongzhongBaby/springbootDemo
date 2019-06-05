package com.example.demo.config;


import com.example.demo.filter.AuthFilter;
import com.example.demo.filter.ContentFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ComponentFilterOrderConfig {
    @Bean
    public AuthFilter MyHiddenHttpMethodFilter() {
        return new AuthFilter();
    }

    @Bean
    public ContentFilter tokenAuthorFilter() {
        return new ContentFilter();//自定义的过滤器
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(MyHiddenHttpMethodFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(9);//order的数值越小 则优先级越高
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(tokenAuthorFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(7);
        return filterRegistrationBean;
    }


}