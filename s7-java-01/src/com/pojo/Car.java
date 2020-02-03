package com.pojo;

import java.io.*;

public class Car implements  Cloneable , Serializable {

    private String color ;
    private Luntai luntai ;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Luntai getLuntai() {
        return luntai;
    }

    public void setLuntai(Luntai luntai) {
        this.luntai = luntai;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        /*   浅度克隆
        Car car = new Car();
        car.setColor("red");
        Luntai luntai = new Luntai();
        luntai.setNum(4);
        car.setLuntai(luntai);
        Car car2 = (Car) car.clone();
        car2.setColor("yellow");
        car2.getLuntai().setNum(3);
        System.out.println(car.getLuntai().getNum());
        System.out.println(car.getColor());
         */

        //深度克隆
        Car car = new Car();
        car.setColor("red");
        Luntai luntai = new Luntai();
        luntai.setNum(4);
        car.setLuntai(luntai);

        ObjectOutputStream os = null;
        ObjectInputStream ois = null;
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(car);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Car car2 = (Car) ois.readObject();// 深度克隆
            car2.getLuntai().setNum(5);
            System.out.println(car.getLuntai().getNum());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
                os.close();
            } catch (IOException e) {
                os = null;
                ois=null;
            }
        }




    }

}
