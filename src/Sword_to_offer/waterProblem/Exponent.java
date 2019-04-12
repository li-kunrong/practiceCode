package Sword_to_offer.waterProblem;

public class Exponent {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * solution:
     *
     */

    public static void main(String[] args){
     new Exponent().Power(2,3);
    }
    public double Power(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        int exp = exponent;
        if (exponent < 0) {
            exp = -exponent;
        }
        double result = power2(base,exp);
        //指数是负数的话就求其倒数
        if (exponent < 0) {
            result = 1/result;
        }
        return result;
    }
    public static double power2(double base, int exp) {
        if (exp == 0)
            return 1;
        if (exp == 1)
            return base;
        //递归求一半的值
        double result = power2(base, exp >> 1);
        //求最终的值，如果是奇数，还要乘以基数
        result *= result;
        if (exp%2 != 0)
            result *= base;
        return result;
    }
}
