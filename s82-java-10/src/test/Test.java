package test;


public class Test {

    // 递归
    public static int sum(int i){
        int s = 0 ;
        if(i!=0){
            s = i + sum(i-1);
        }
        return s ;
    }

    public static void main(String[] args) {

        float f = (int)1.234;
        System.out.println(sum(100));

        for (int j = 1 ; j<=35 ; j++) {
            if ((j * 2 + (36 - j) * 4) == 100) {
            System.out.println(j + "\t" + (36 - j));
        }
    }
    }
}
