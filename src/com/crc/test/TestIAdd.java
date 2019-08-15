package com.crc.test;

/**
 * @Author: kunrong
 * @Date: 2019/8/7 16:16
 * @Description:
 **/
public class TestIAdd {

    static{
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
        x--;
        myMethod( );
        System.out.println(x+y+ ++x);
    }
    public static void myMethod( ){
        y=x++ + ++x;
    }
}
