package com.inter;

import com.pojo.Dep;

public class Test9 {

    public static void change(Dep dep){
        dep.setId(2);
    }


    public static void main(String[] args) {
        Dep dep = new Dep();
        dep.setId(1);
        change(dep);
        System.out.println(dep.getId());
    }
}
