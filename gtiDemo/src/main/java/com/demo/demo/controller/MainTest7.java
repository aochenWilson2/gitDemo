package com.demo.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2020/1/2 17:16
 */
public class MainTest7 {
    public static void main(String[] args) throws ParseException {
//        String string = "2019/01/01";
//        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
//        Date date = df.parse(string);


        Calendar instance = Calendar.getInstance();
        instance.set(2019,Calendar.DECEMBER,7);
        Date firstDayOfWeek = getFirstDayOfWeek(instance.getTime());
        System.out.println(firstDayOfWeek);

    }


    /**
     * 获取指定日期所在周的周一
     *
     * @param date      日期
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            c.add(Calendar.DAY_OF_MONTH, -1);
        }
        c.add(Calendar.DATE, c.getFirstDayOfWeek() - c.get(Calendar.DAY_OF_WEEK) + 1);
        return c.getTime();
    }
}
