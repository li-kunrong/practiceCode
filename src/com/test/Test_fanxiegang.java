package com.test;

/**
 * @author kunrong
 * @description
 * @date 2019/3/21 20:18
 */
public class Test_fanxiegang {
    public static void main(String[] args){
        String s = "192.168.10.112\\好的\\坏的";
        s= s.replaceAll("\\\\","/");
        System.out.println(s);
    }
}
