package com.test;

/**
 * @Author: kunrong
 * @Date: 2019/8/14 16:32
 * @Description:
 **/
public class Confusing {
    public Confusing(Object o) {
        System.out.println("Object");
    }
    public Confusing(double[] dArray) {
        System.out.println("double array");
    }
    public static void main(String args[]) {
        new Confusing(null);
    }
}
