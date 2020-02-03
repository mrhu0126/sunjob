package com.inter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {

    public static void main(String[] args) {
        String regex = "^\\d{17}[\\dxX]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("43032119940126516x");
        if(matcher.find()){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
