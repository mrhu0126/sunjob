package com.test;


public class Test {

    public static void main(String[] args) {
        //   匿名方法
        Test test = new Test();
        MathOperation addOperation = (int a , int b )->a+b;
        System.out.println(addOperation);

        int n = test.operate(1,2,addOperation);
        System.out.println(n);

        MathOperation subtraction = (a,b)->a-b;
        int m = test.operate(1,2,subtraction);
        System.out.println(m);

        GreetingService greetingService = message -> {System.out.println("hello"+message);};
        greetingService.sayMessage("jack");


    }

    //接口
    @FunctionalInterface
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}
