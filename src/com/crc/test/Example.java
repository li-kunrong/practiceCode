package com.crc.test;

/**
 * @Author: kunrong
 * @Date: 2019/8/7 17:02
 * @Description:
 **/

public class Example {
    String str = new String("good");
    char[] ch = {'a','b','c'};
    public static void main(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str +"and");
        System.out.print(ex.ch);


        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.print(n1 == n2);
        System.out.print(",");
        System.out.println(n1 != n2);
    }

    public void change(String str, char ch[]){
        str= "test ok";
        ch[0]= 'g';
    }
}