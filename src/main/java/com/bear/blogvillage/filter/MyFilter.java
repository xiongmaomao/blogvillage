package com.bear.blogvillage.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init==============");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========filter start");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println("============="+request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("=======filter end");
    }

    @Override
    public void destroy() {
        System.out.println("========destroy");
    }
}
