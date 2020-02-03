package com.pojo;

public class Teacher {
    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    private int tid;
    private String tname;
    private String[] loves;

    public Teacher(int tid, String tname) {
        System.out.println("aaa");
        this.tid = tid;
        this.tname = tname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        System.out.println("aa");
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        System.out.println("bb");
        this.tname = tname;
    }
}
