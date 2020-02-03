package com.inter;

import java.util.HashMap;

public class Test5 {
    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("a" , 10);
        map.put("a" , 20);
        // HashMap  允许空k和空v   HashTable 不允许空k或空v
        // HashMap  异步          HashTable 同步
        map.put(null, null);
        System.out.println(map.get("a"));

    }
}
