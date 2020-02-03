import com.sun.jmx.snmp.internal.SnmpSubSystem;

public class Test {

    public static void main(String[] args) {

        String s = "abcd";
        String s2 = new String("abcd");
        String s3 = "abcd";
        String s4 = new String("abcD");

        System.out.println(s==s3);
        System.out.println(s2==s4);

        System.out.println(s.equals(s4));
        System.out.println(s.equalsIgnoreCase(s4));
    }
}
