package interview.wangyi2018;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/7/31 15:03
 * @Description:
 **/
public class PaiLie4Bei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0) {
            int m = scanner.nextInt();
            int a[] = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = scanner.nextInt();
            }
            boolean flag = check(a);
            if (flag)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    public static boolean check(int[] a) {
        boolean res = false;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (isFour(a[i])){
                count++;
            }
        }
        System.err.println(a.length/2+" "+count);
        if (count>=(a.length/2))
            res = true;
        return res;
    }

    public static boolean isFour(int a) {
        if (a%4==0)
            return true;
        else
            return false;
    }
}
