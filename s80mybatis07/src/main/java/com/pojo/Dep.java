package com.pojo;

public class Dep {

    private int depid ;

    public Dep() {
    }

    private String depname ;

    public Dep(int depid, String depname) {
        this.depid = depid;
        this.depname = depname;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }
}
