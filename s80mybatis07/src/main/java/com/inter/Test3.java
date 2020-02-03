package com.inter;

import com.pojo.Dep;
import com.service.DepService;

public class Test3 {
    public static void main(String[] args) {
        DepService depService = new DepService();
        depService.add(new Dep(5 , "国防部"));
    }
}
