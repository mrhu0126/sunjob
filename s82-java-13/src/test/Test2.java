package test;

public class Test2 {
    public static void main(String[] args){
        String s = "cabcdefg" ;
        char ch = s.charAt(4);
        System.out.println(ch);
        int index = s.indexOf('j');
        System.out.println(index);

        String s2 = s.toUpperCase();
        System.out.println(s);
        System.out.println(s2);
        s2 = s2.toLowerCase();
        System.out.println(s2);

    }
}
