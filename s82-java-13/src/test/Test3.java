package test;

public class Test3 {
    public static void main(String[] args){
        String s = "  as  cd  ";
        s=s.trim();
        System.out.println(s.length());

        String s2= new String("abc");
        String s3 = new String("abc");
        System.out.println(s2.hashCode()==s3.hashCode());


    }
}
