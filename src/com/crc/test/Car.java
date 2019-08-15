package com.crc.test;

/**
 * @Author: kunrong
 * @Date: 2019/8/7 16:32
 * @Description:
 **/
public class Car extends Vehicle
{
    public static void main (String[] args)
    {
        new  Car(). run();
    }
    public final void run()
    {
        System. out. println ("Car");
    }
}
class Vehicle
{
    private final void run()
    {
        System. out. println("Vehicle");
    }
}