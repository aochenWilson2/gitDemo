package com.demo.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/12/30 10:12
 */
public class MainTest5 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2020/03/02");
        list.add("2020/03/06");
        list.add("2020/03/03");
        list.add("2020/03/04");
        list.add("2020/03/07");
        list.add("2020/03/05");
        list.add("2019/12/08");
        Collections.sort(list);

        int i = list.indexOf("2020/03/08");
        String s = list.get(i - 3);

        System.out.println(s);


//        List<String> dates = getDatesByIntervalDay("2020/03/02", 6);
//        System.out.println(dates);
    }


    /**
     * 获取两个日期字符串之间的日期集合
     *
     * @param startTime:String
     * @param endTime:String
     * @return list:yyyy/MM/dd
     */
    public static List<String> getBetweenDate(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        // 声明保存日期集合
        List<String> list = new ArrayList<>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime() <= endDate.getTime()) {
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate = calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param time        指定时间
     * @param intervalDay 间隔天数(正数是往后, 负数是往前)
     * @return 指定时间到间隔天数内的所有时间
     */
    public static List<String> getDatesByIntervalDay(String time, int intervalDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        List<String> result = new ArrayList<>();
        try {
            Date startDate = sdf.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE, intervalDay);
            Date endDate = calendar.getTime();
            String endTime = sdf.format(endDate);
            if (intervalDay < 0) {
                result = getBetweenDate(endTime, time);
            } else {
                result = getBetweenDate(time, endTime);
            }
        } catch (ParseException e) {
            //logger.error("getDatesByIntervalDay {}" + e.getMessage());
        }
        return result;
    }
}