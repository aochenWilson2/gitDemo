package com.demo.demo.controller;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/12/12 3:38
 */
public class MainTest3 {
    public static void main(String[] args) {
       // List<String> list = new ArrayList<>();

//        Optional<String> option = list.stream().filter(a -> a.contains("instance")).findFirst();
//        if(option.isPresent()){
//            System.out.println("ahah");
//        }else{
//            System.out.println("结束了");
//        }
//        Map<String, Integer> map = new TreeMap<>();
//        map.put("2020/01/20", 20);
//        map.put("2020/01/06", 06);
//        map.put("2020/01/13", 13);
//        System.out.println(map);
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            map.put(key, value - 1);
//            System.out.println("map////////"+map);
//        }
//        System.out.println("map..."+map);
//        String syncFromKeyName = "2019/01/03";
//        System.out.println(syncFromKeyName.compareTo("2018/01/04"));
        //System.out.println(System.currentTimeMillis());

//        String operatorKey = System.currentTimeMillis() + "-" + RandomStringUtils.randomAlphanumeric(4);
//        System.out.println(operatorKey);
        Map<String, Integer> map = new HashMap<>();
        map.remove("a");
        System.out.println(map);
    }
}
