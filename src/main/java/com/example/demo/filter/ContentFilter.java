package com.example.demo.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;





public class ContentFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       /* byte[] buf = new byte[1024];
        while(servletRequest.getInputStream().read(buf)>0){
          ;
        }*/
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
