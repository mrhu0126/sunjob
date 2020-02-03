package com.inter;

import com.pojo.Emp;

import java.util.HashSet;
import java.util.Set;

public class Test6 {

    public static void main(String[] args) {
        Set<Emp> set = new HashSet<Emp>();
        Emp emp = new Emp();
        emp.setEmpid(1);
        emp.setEmpname("秦寿");

        Emp emp2 = new Emp();
        emp2.setEmpid(2);
        emp2.setEmpname("夏剑");

        Emp emp3 = new Emp();
        emp3.setEmpid(1);
        emp3.setEmpname("秦寿2");

        set.add(emp);
        set.add(emp2);
        set.add(emp3);

        System.out.println(set.size());
        for (Emp e : set) {
            System.out.println(e.getEmpname());
        }




    }
}
