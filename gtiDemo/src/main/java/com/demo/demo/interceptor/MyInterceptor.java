package com.demo.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器会拦截所有的控制器，不管是spring的还是自定义的
 *
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 16:00
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 可以获得Http原始的请求和响应信息，也拿得到响应方法的信息，但是拿不到方法响应中参数的值
     * 在web开发中，拦截器是经常用到的功能。它可以帮我们验证是否登陆、预先设置数据以及统计方法的执行效率等。
     * 在spring中拦截器有两种，第一种是HandlerInterceptor，第二种是MethodInterceptor。
     * HandlerInterceptor是SpringMVC中的拦截器，它拦截的是Http请求的信息，优先于MethodInterceptor。
     * 而MethodInterceptor是springAOP的。前者拦截的是请求的地址，而后者是拦截controller中的方法，
     * 因为下面要将Aspect，就不详细讲述MethodInterceptor
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Interceptor preHandler name:" + handler.getClass().getName());

        //true的话 就是选择可以调用后面的方法  也就是controller中的method1方法
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //方法被调用或者抛出异常都会被执行
        System.out.println("Interceptor afterCompletion");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //控制后方法执行之后会进行，抛出异常则不会被执行
        System.out.println("Interceptor postHandle");
    }
}
