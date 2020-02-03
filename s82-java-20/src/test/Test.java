package test;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);//   加最后
        arrayList.add(1,4);  //  加在指定位置

        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(6);
        arrayList1.add(7);

        arrayList.add(arrayList1);//  5
        arrayList.addAll(arrayList1);

        //arrayList.clear();//  清空

        // 1 4 2 3 [6,7]   6 7


        System.out.println(arrayList.get(2));
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.size());
        arrayList.remove(2);//   移除2号位置
        System.out.println(arrayList.get(2));
        arrayList.set(2 , 8);// 替换
        System.out.println(arrayList.get(2));
    }

}
