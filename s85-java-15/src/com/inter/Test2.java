package com.inter;

import com.pojo.Emp;

import java.util.Set;
import java.util.TreeSet;

public class Test2 {

    public static void main(String[] args) {
        Set<Emp> set = new TreeSet<Emp>();
        Emp emp = new Emp();
        emp.setEmpid(1);
        emp.setEmpname("张三");

        Emp emp2 = new Emp();
        emp2.setEmpid(2);
        emp2.setEmpname("李四");

        Emp emp3 = new Emp();
        emp3.setEmpid(3);
        emp3.setEmpname("王五");

        set.add(emp);
        set.add(emp2);
        set.add(emp3);

        for (Emp e : set) {
            System.out.println(e.getEmpid()+"\t" + e.getEmpname());
        }

    }

}
