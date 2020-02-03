package com.pojo;

import java.util.Map;

public class Student {

    private int stuid ;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    private String stuname ;
    private String[] loves ;
    private Map other ;
    private Teacher teacher;


    public Map getOther() {
        return other;
    }

    public void setOther(Map other) {
        this.other = other;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        System.out.println(this);
        System.out.println("来了");
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        System.out.println("来了");
        this.stuname = stuname;
    }
}
