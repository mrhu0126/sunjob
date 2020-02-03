package com.inter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {

    public static void main(String[] args) {
        String regex = "\\w{2,4}+\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        String s = "abc22";
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }

}
