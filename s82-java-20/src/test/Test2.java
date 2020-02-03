package test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test2 {

    public static void main(String[] args) {
        //  泛型
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        //遍历集合
        for (int i = 0 ; i <arrayList.size() ; i++){
            System.out.println(arrayList.get(i));
        }

        //  foreach      String  集合中的数据类型   s 自己取的变量名     arrayList  要遍历的集合
        for (String s : arrayList) {
            System.out.println(s);
        }

        //迭代器
        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext()){//判断是否有下一个
            System.out.println(iterator.next());
        }




    }
}
