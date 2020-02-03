package com.pojo;

public class Emp {
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
    public int hashCode() {
        return empid;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Emp){
            if(((Emp)obj).getEmpid()==this.empid){
                return true ;
            }
        }
        return false ;
    }
}
