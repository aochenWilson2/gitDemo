package com.demo.demo.controller;


import org.apache.commons.lang3.time.DateUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2020/1/2 14:14
 */
public class MainTest6 {


    public static void main(String[] args) {
        //TODO 一个月有几个周四,这个月就有几个周
//        int year = 2019;
//        int month = 11;//月份从0开始,10代表11月份
//        Calendar calendar = new GregorianCalendar(year, month, 1);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019,11,1);
        int i = 1;
        while (calendar.get(Calendar.MONTH) < calendar.get(Calendar.MONTH) + 1) {
            calendar.set(Calendar.WEEK_OF_YEAR, i++);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            if (calendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
                System.out.printf("星期四：%tF%n", calendar);
            }
            Date date = new Date();
        }









//        Calendar instance = Calendar.getInstance();
//
//        instance.set(Calendar.YEAR, 2019);
//        instance.set(Calendar.MONTH,12);
//        instance.setFirstDayOfWeek(Calendar.THURSDAY);
//        System.out.println("------------" + instance.get(Calendar.YEAR) + "年" + (instance.get(Calendar.MONTH) + 1) + "月的天数和周数-------------");
//
//        System.out.println("周数：" + instance.getActualMaximum(Calendar.WEEK_OF_MONTH));
//
//        LocalDate localDate = LocalDate.of(2019, 12, 1);
//        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
//        System.out.println(dayOfWeek.getValue());
//        int month = localDate.lengthOfMonth();
//        System.out.println(month);


        //System.out.println("天数：" + instance.getActualMaximum(Calendar.DAY_OF_MONTH));
        //System.out.println("最小周数：" + instance.getActualMinimum(Calendar.WEEK_OF_MONTH));
        //System.out.println("周数:"+instance.getMaximum(Calendar.WEEK_OF_MONTH));

    }

}
