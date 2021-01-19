package com.demo.demo.controller;

import com.demo.demo.controlleradvice.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 13:50
 */
@RequestMapping("/controller2")
@RestController
public class Controller2 {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping("/method1")
    public String method1() {
        HttpSession session = httpServletRequest.getSession();
        System.out.println("this is controller2 method1");
        System.out.println("controllerAdvice执行了");
        throw new CustomException(500L, "controllerAdvice测试");
    }
}
