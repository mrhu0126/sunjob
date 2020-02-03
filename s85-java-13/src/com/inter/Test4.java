package com.inter;

public class Test4 {

    public static void test(int score){
        if(score<0){
            throw  new RuntimeException("成绩有错误");
        }
    }

    public static void main(String[] args) {
        test(-10);
    }
}
