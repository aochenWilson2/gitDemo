package com.demo.demo.controller;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 13:52
 */
public class MainTest2 {
    public static void main(String[] args) throws ParseException {
//        Calendar instance = Calendar.getInstance();
//        instance.setFirstDayOfWeek(Calendar.THURSDAY);
//        System.out.println("------------" + instance.get(Calendar.YEAR) + "年" + (instance.get(Calendar.MONTH) + 1) + "月的天数和周数-------------");
//        System.out.println("天数：" + instance.getActualMaximum(Calendar.DAY_OF_MONTH));
//        System.out.println("周数：" + instance.getActualMaximum(Calendar.WEEK_OF_MONTH));
        List<String> result = new ArrayList<>();
        String startTime = "2019/12/02";
        String endTime = "2020/06/22";
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date startDate = df.parse(startTime);
        Date endDate = df.parse(endTime);
        result.add(startTime);
        while (startDate.before(endDate)) {
             startDate = DateUtils.addDays(startDate, 7);
            String string = df.format(startDate);
            result.add(string);
        }
        System.out.println(result);



    }


}
