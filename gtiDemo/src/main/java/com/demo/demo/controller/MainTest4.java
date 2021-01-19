package com.demo.demo.controller;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import sun.util.calendar.CalendarUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/12/24 15:33
 */
public class MainTest4 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateString = "2019/12/24";
        Calendar instance = Calendar.getInstance();
        int weeksInWeekYear = instance.getWeeksInWeekYear();
        System.out.println(weeksInWeekYear);

    }

    public static List<Calendar> getMondaysForYear(int year, int monthCount) {
        List<Calendar> result = new ArrayList<>();
        //获取year/1/1对应的周一
        Calendar firstCalendar = getYearFirstDayMonday(year);
        //解析firstCalendar的年月日
        int firstYear = firstCalendar.get(Calendar.YEAR);
        int firstMonth = firstCalendar.get(Calendar.MONTH);
        int firstDate = firstCalendar.get(Calendar.DATE);
        //每月按5周计,获取总共几周
        int week = monthCount * 5;
        //每年至少有52个周，至多有53个周
        for (int i = 0; i < week; i++) {
            //日期依次+7 获取所有的周一
            Calendar tempCalendar = Calendar.getInstance();
            tempCalendar.set(firstYear, firstMonth, firstDate);
            tempCalendar.add(Calendar.DATE, 7 * i);
            result.add(tempCalendar);
        }
        return result;
    }

    private static Calendar getYearFirstDayMonday(int year) {
        //定义本年的第一天
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 1);
        //星期几与每周的第几天一一对应
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        //根据当前日期天数,获取本周周一
        calendar.add(Calendar.DATE, -dayOfWeek + 1);
        return calendar;
    }

}
