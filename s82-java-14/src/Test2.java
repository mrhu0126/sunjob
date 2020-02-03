public class Test2 {

    public static void main(String[] args) {
        /*
        String s = "www.baidu.com";
        s=s.replace("w" ,"");
        System.out.println(s.length());
         */

        /*
        String s = "ww.ww.ww.baidu.com";
        s=s.replaceAll("\\." ,"");\\ 转译
        System.out.println(s.length());
         */

        /*
        String s = "www.baidu.com";
        s=s.replaceAll("\\w" , "");
        System.out.println(s.length());
         */

        /*
        String s = "http://www.baidu.com";
        System.out.println(s.startsWith("http"));
        System.out.println(s.endsWith("com"));
        */


        /*
        String s = "saijie=sunjob=saijiebo";
        String[] strings = s.split("=" , 2);
        System.out.println(strings.length);
        System.out.println(strings[0]);
        System.out.println(strings[1]);
        */

        String s = "abcdef";
      //  s=s.substring(3);
        s=s.substring(2,10);
        System.out.println(s);

    }
}

