package interview.wangyi2019;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/8/3 16:33
 */
public class Count {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        while (q>0) {
            int x = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (a[i]>=x) {
                    a[i]--;
                    count++;
                }
            }
            System.out.println(count);
            --q;
        }
    }
}
