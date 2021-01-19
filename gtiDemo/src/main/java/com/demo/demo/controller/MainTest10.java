package com.demo.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2020/1/13 10:51
 */
public class MainTest10 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        List<Integer> list2 = new ArrayList<>();
        list.addAll(list2);
        System.out.println(list);


//        Set<Integer> years = getYears("2018/01", "2018/12");
//        System.out.println(years);

    }


    public static  Set<Integer> getYears(String fromYearMonth, String toYearMonth){
        Set<Integer> result = new HashSet<>();
        int from = Integer.parseInt(fromYearMonth.substring(0, 4));
        int to = Integer.parseInt(toYearMonth.substring(0, 4));
        for (int i = from; i <= to; i++) {
            result.add(i);
        }
        return result;
    }






    public static List<Date> getDatesByMonth(int month, int sopRangeMonths) {
        Calendar cal = Calendar.getInstance();

        int monthRange = cal.get(Calendar.MONTH) + sopRangeMonths;

        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 15);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        //TODO 根据sop.rangeMonths计算当前月向后扩展的月数
        List<Date> result = new ArrayList<>();
        result.add(cal.getTime());
        for (int i = 0; i < monthRange; i++) {
            cal.add(Calendar.MONTH, 1);
            result.add(cal.getTime());
        }
        return result;
    }


}
