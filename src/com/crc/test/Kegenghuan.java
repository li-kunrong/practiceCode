package com.crc.test;

/**
 * @Author: kunrong
 * @Date: 2019/8/8 9:13
 * @Description:
 **/
public class Kegenghuan {
    public static void main(String[] args) {
        if (returnTest())
            System.out.println("haha");

    }


    public static boolean returnTest()
    {
        try
        {
            return true;
        }
        catch (Exception e)
        {

        }
        finally
        {
            return false;
        }
    }
}
