package com.inter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //泛型
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        //list.add("3");  报错
        list.add(3);

        /*
        for (int i = 0 ;i<list.size() ; i++){
            System.out.println(list.get(i));
        }
        */
            //  Integer 放的数据类型   integer  自己取的变量名 list  要遍历的集合
       /*
        for (Integer integer : list) {
            System.out.println(integer);
        }
        */
       //迭代器
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            //取下一个
            System.out.println(iterator.next());
        }
    }
}
