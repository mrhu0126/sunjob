package test;

public class Test{
    int a = 10;
    //递归
    public static int sum(int i){
        int s = 0;
        if(i!=0){
            s = sum(i-1) + i ;
        }
        return s;
    }



    public static void  main(String[] args) {
        System.out.println(sum(100));
        System.out.println(0.01 + 0.05);
        System.out.println(10/0.0);
        float f = (float)10.0 ;
        int a = 20 ;
       // int a = 10 ;
        System.out.println(a);

    }
}
