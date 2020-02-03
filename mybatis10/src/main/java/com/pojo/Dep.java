package com.pojo;

import java.io.Serializable;

public class Dep implements Serializable {


    private int did ;
    private String dname ;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
