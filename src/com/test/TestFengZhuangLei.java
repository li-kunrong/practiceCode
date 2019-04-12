package com.test;

/**
 * @author kunrong
 * @description
 * @date 2019/3/19 16:12
 */
public class TestFengZhuangLei {
    public static void main(String[] args){
//        Integer l1 = new Integer(1);
//        Integer l2 = new Integer(1);
//        System.out.println(l1==l2);
//        Integer l3 = 1;
//        System.out.println(l1==l3);
//        Integer l5 =1;
//        System.out.println(l3==l5);
//        int l4 = 1;
//        System.out.println(l1==l4);

        double a1 = 1.99999999999999999;
        double a2 = 1.99999999999999998;
        System.out.println(a2== a1);
        System.out.println(Double.doubleToLongBits(a1)== Double.doubleToLongBits(a2));
    }
}
