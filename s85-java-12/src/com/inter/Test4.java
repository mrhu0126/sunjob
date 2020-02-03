package com.inter;

import com.pojo.Dep;

public class Test4 {

    public static void chageDepid(Dep dep){
        dep.setDepid(2);
    }

    public static void main(String[] args) {
        Dep dep = new Dep();
        dep.setDepid(1);
        chageDepid(dep);
        System.out.println(dep.getDepid());
    }
}
