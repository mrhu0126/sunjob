package test;

public class Test2 {

    public static void test() throws ClassNotFoundException {
        Class.forName("");  //加载类
    }

    public static void main(String[] args) throws ClassNotFoundException {
        test();
    }

}
