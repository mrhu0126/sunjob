package com.inter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
      //  String regex = "[abc]" ;
      //  String regex = "[a-z&&[d-h]]" ;
       // String regex = "\\W" ;
        String regex = "\\d{3}" ;
        Pattern pattern = Pattern.compile(regex);
        String s = "90$9";
        // 字符串s 和模板进行比较
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){//如果匹配成功
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
