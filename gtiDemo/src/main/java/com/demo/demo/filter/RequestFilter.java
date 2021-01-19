package com.demo.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 15:23
 */
@WebFilter(filterName = "requestFilter", urlPatterns = "/*")
@Component
public class RequestFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    /**
     * 可以获得Http原始的请求和响应信息，但是拿不到响应方法的信息
     * filter是属于Servlet规范的，不属于Spring
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init method");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String contentType = request.getContentType();
        //这里可以做token的获取和解析)
        System.out.println("filter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy method");
    }
}
