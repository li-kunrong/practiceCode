package Sword_to_offer.waterProblem;

public class NumberOfOne {
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    public static int NumberOf1(int n) {
        int target = 0;
        for(int i = 0; i < 32; i++) {
            target += (n&1);
            System.out.println(n);
            n >>>= 1;
        }
        return target;
    }

    public static void main(String []args){
        NumberOf1(-1);
    }
}
