package com.util;

import com.pojo.Dep;

import java.util.Comparator;

//指定排序规则
public class MySort implements Comparator<Dep> {

    @Override
    public int compare(Dep o1, Dep o2) {
        return o2.getDepid()-o1.getDepid();
    }

}

