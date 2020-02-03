package test;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入借书时间");
        String bstring = scanner.nextLine();
        System.out.println("请输入还书时间");
        String rstring = scanner.nextLine();

        System.out.println(bstring);
        System.out.println(rstring);


    }
}
