package test;

public class Test extends  Object{
    public static void main(String[] args) {

        /*
        Integer integer = 10;
        Integer integer1 = 10;
        Integer integer2 = integer + integer1 ;
        System.out.println(integer2);

        System.out.println(integer.hashCode());
        System.out.println(integer2.hashCode());

         */

        /*
        String s = "11a";
        Integer integer3 = new Integer(s);
        System.out.println(integer3);
         */

        /*
        Integer integer = new Integer(100);
        Integer integer1 = new Integer(100);
        System.out.println(integer==integer1);
        System.out.println(integer.equals(integer1));
         */

        /*
        Integer integer = 100;
        Integer integer1 = 100;
        System.out.println(integer==integer1);
        System.out.println(integer.equals(integer1));

         */

        /*
        Integer integer = 200;
        Integer integer1 = 200;
        System.out.println(integer==integer1);
        System.out.println(integer.equals(integer1));
        System.out.println(integer.toString());
         */


        //装箱和拆箱
        /*
        int a = 10 ;
        Integer integer = a ;
        int b = integer;
         */

        /*
        int a = 10 ;
        Integer integer = new Integer(a);
        int b = integer.intValue();
        */

        /*
        //转换   String  包装类的转换
        String s = "11";
        Integer integer = new Integer(s);
        Integer integer1 = Integer.parseInt(s);// 1

        Integer integer2 = 10;
        String s2 = integer2 + "";  // 1
        String s3 = integer2.toString();
         */

        //包装类对象的转换
        /*
        Integer i = 10 ;//  转换为Long
        Object object = i ;
        Long l = (Long)object ;
        System.out.println(l);
        */

        /*
        Integer i = 10 ;//  转换为Long
        int a = i ;
        long b = a ;
        Long l = b ;
        System.out.println(l);
        Long l2 = i.longValue();
        System.out.println(l2);
         */
        /*
        float f = 0.001f;
        float d = 0.005f;
        double a = f + d ;
        System.out.println(a);
        */

        System.out.println(2.00 -1.10);

    }
}
