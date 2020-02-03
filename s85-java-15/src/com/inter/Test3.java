package com.inter;

import com.pojo.Dep;
import com.util.MySort;

import java.util.Set;
import java.util.TreeSet;

public class Test3 {

    public static void main(String[] args) {
        Set<Dep> set = new TreeSet<Dep>(new MySort());
        Dep dep = new Dep();
        dep.setDepid(1);
        dep.setDepname("小卖部");

        Dep dep2 = new Dep();
        dep2.setDepid(2);
        dep2.setDepname("国防部");

        Dep dep3 = new Dep();
        dep3.setDepid(3);
        dep3.setDepname("宣传部");

        set.add(dep);
        set.add(dep2);
        set.add(dep3);


        for (Dep d : set) {
            System.out.println(d.getDepid()+"\t" + d.getDepname());
        }


    }

}
