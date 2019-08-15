package interview.wangyi2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/6 14:39
 * @Description:
 **/
public class JiaCheng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a[] = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int result = 0;
        if (a[0]==1&&a[1]==1&&a[2]==1){
            result = 3;
        }else if (a[0]==1&&a[1]==1){
            result=2*a[2];
        }else if (a[0]==1) {
            result = Math.max((a[0]+a[1])*a[2],(a[0]+a[1])+a[2]);
        }else {
            result= a[0]*a[1]*a[2];
        }
        System.out.println(result);
    }
}
