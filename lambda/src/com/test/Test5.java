package com.test;

public class Test5 {


    interface MathOperation {
        int operation(int a, int b);
    }


    public static void main(String[] args) {
        Test5 test5 = new Test5();

        MathOperation addOperation = (int a, int b ) -> {
            return a + b;
        };

        int n = test5.operate(1, 2, addOperation);
        System.out.println(n);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


}
