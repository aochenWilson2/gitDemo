package com.demo.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 13:51
 */
public class MainTest1 {

    public static void main(String[] args) {

        List<Project> projectList = new ArrayList<>();
        Project project1 = new Project("11", "P-971697");
        Project project2 = new Project("13", "P-900545");
        projectList.add(project1);
        projectList.add(project2);

        //{projectId,firstDate}
        Map<String, String> firstDateMap = new HashMap<>(16);
        firstDateMap.put("11", "2019/03/03");
        firstDateMap.put("13", "2019/02/06");
        //{projectId,total}
        Map<String, Integer> totalMap = new HashMap<>(16);
        totalMap.put("11", 111);
        totalMap.put("13", 13);

        projectList.sort((p1, p2) -> {
            String p1ProjectNumber = p1.getProjectNumber();
            String p2ProjectNumber = p2.getProjectNumber();

            String p1FirstDate = firstDateMap.get(p1.getId());
            String p2FirstDate = firstDateMap.get(p2.getId());

            if (p1FirstDate.compareTo(p2FirstDate) == 0) {
                return p1ProjectNumber.compareTo(p2ProjectNumber);
            } else {
                return p1FirstDate.compareTo(p2FirstDate);
            }
        });
        System.out.println(projectList);
    }
}
