package com.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 13:50
 */
@RequestMapping("/controller3")
@RestController
public class Controller3 {
    @GetMapping("/method1")
    public String method1() {
        return null;
    }
}
