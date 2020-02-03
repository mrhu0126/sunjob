package test;

public class Test3 {
    public static void test() {
        //alt + Enter
        try {
            System.out.println("1");
            Class.forName("test.Tes");  //加载类
            System.out.println("2");
        } catch (ClassNotFoundException e) {
            System.out.println("3");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
