package test;

import java.math.BigDecimal;

public class Test2 {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(0.01));
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(0.05));
        double d = bigDecimal.add(bigDecimal1).doubleValue();
        System.out.println(d);
        System.out.println(0.05+0.01);
    }
}
