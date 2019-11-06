package com.example.demo.config;

import com.example.demo.interceptor.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor()).addPathPatterns("/**");//日志拦截请求
    }

    @Override //添加resource路径映射 用于ckeditor 上传图片文件
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/image/**").addResourceLocations("file:G:\\upload\\");
    }

    //视图控制器配置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/importExcel").setViewName("importExcel.html");
        registry.addViewController("/ckeditor").setViewName("ckeditor.html");
    }


}
