package interview.wangyi2018;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/7/31 14:16
 * @Description:
 **/
public class DingYixiangfanshu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result  = 0;
        int temp = num;
        while (num>0) {
            result*=10;
            result+=(num%10);
            num/=10;
        }
        result+=temp;
        System.out.println(result);
    }
}
