package com.demo.demo.sop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP
 *
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 14:52
 */
@Aspect
@Component
public class LogAop {
    /**
     * 需要引入 aspectjrt & aspectjweaver 包, 同时在启动类上使用@EnableAspectJAutoProxy注解.
     * 可以拿得到方法响应中参数的值，但是拿不到原始的Http请求和相对应响应的方法，
     * 基于Controller层。对于统一异常处理和日志记录非常方便，有效地减少了代码的重复率。
     */
    @Pointcut("execution(* com.demo.demo.controller.*.*(..))")
    public void loginPointCut() {
    }

    @Around("loginPointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around前执行了");
        Object result = joinPoint.proceed();
        System.out.println("around后执行了");
        return result;
    }


    @Before("loginPointCut()")
    public void beforeMethod() {
        System.out.println("before执行了");
    }

}
