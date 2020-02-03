package test;

public class Test4 implements Cloneable{

    public static void test() {

        try {
            System.out.println("1");
            Class.forName("test.Tes");  //加载类
            System.out.println("2");
            Test4 test4 = new Test4();
            Test4 test41 = (Test4)test4.clone();
            System.out.println("3");
        } catch (CloneNotSupportedException e) {
            System.out.println("4");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("5");
            e.printStackTrace();
        } finally {
            System.out.println("aa");
        }

    }

    public static void main(String[] args) {
        test();
    }

}
