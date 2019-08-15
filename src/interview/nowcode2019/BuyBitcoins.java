package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 14:11
 * @Description:
 **/
public class BuyBitcoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1[] = s.split(" ");

        int n = s1.length;
        int a[] = new int[s1.length];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }

        int sofar_min = a[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (a[i]<sofar_min)
                sofar_min= a[i];
            res = Math.max(a[i]-sofar_min,res);

        }
        System.out.println(res);
    }
}
