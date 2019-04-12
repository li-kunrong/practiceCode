package interview.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/3/29 15:11
 */
public class MaxNumber {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int a[] = new int[3];
        for (int i = 0; i < 3; i++)
            a[i] = scanner.nextInt();
        Arrays.sort(a);
        if (a[0] == 1) {
            if (a[1] ==1) {
                if (a[2]==1){
                    System.out.println(3);
                }else {
                    a[2]*=(a[0]+a[1]);
                    System.out.println(a[2]);
                }
            }else {
                a[2]*=(a[0]+a[1]);
                System.out.println(a[2]);
            }
        }else {
            System.out.println(a[2] * a[1] *a[0]);
        }
    }
}
