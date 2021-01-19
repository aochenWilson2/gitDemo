package com.demo.demo.controller;

/**
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/10/21 10:29
 */
public class Project {
    private String id;
    private String projectNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }


    public Project(String id, String projectNumber) {
        this.id = id;
        this.projectNumber = projectNumber;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", projectNumber='" + projectNumber + '\'' +
                '}';
    }
}
