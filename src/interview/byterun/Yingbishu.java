package interview.byterun;

import java.util.Scanner;

public class Yingbishu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int num = 1024-n;
        int result  = 0;
        result+=num/64;
        num%=64;
        result+=num/16;
        num%=16;
        result+=num/4;
        num%=4;
        result+=num;
        System.out.println(result);
    }
}
