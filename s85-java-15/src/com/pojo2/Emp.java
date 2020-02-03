package com.pojo2;

public class Emp implements Comparable<Emp> {

    private int empid ;
    private String empname ;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }



    @Override
    public int compareTo(Emp o) {
        return o.empid - this.empid;
    }

}
