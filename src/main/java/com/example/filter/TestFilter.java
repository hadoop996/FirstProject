package com.example.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;


/**
 * @author 郝少杰
 * @date 2021/4/7 16:49
 */
@Slf4j
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.error("123");
        log.info("123");
        log.info("初始化拦截器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入拦截器");
    }

    @Override
    public void destroy() {
        log.error("销毁拦截器");
    }
}
