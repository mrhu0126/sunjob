package test;

public class Test {

    private int operate(int a, int b, MathOperation mathOperation){
         final  int c = 10;
        return mathOperation.operations(a, b);
    }

    public static void main(String[] args) {

        MathOperation addition = ( a,  b)->{int c =a+b;return c;} ;
        MathOperation subtraction = (int a , int b)->a-b;
        Test test = new Test();
        int n = test.operate(1,2,addition);
        int m = test.operate(1,2 , subtraction);
        System.out.println(n);

        String s ="abc";
        s = "";

    }

}
