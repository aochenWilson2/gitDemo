package com.demo.demo.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2020/1/10 10:17
 */
public class MainTest9 {
    public static void main(String[] args) {
        Integer change = 31;
        Integer sum = 90;


        DecimalFormat df = new DecimalFormat("0");
        float rate = 1 - (float) change / sum;
        String percentRate = df.format(rate * 100 )+"%";

        System.out.println(percentRate);


        float f = (float) (0.97 + 0.98 + 0.99)/3;
        System.out.println(f);

    }



}
