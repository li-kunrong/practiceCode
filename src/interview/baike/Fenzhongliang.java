package interview.baike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/23 20:41
 * @Description:
 **/
public class Fenzhongliang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int sum[] = new int[n];
        sum[0] = a[0];
        for (int i= 1; i < n; i++) {
            sum[i]= sum[i-1]+a[i];
        }
//        for (int i= 0; i < n; i++) {
//            System.out.println(sum[i]);
//        }
        int curCha = n-2;
        int curValue = Math.abs(sum[n-2] - a[n-1]);
        for (int i = n-2; i>=0; i--) {
            int tempCha = Math.abs(i+1-(n-i-1));
            int tempVaule = Math.abs(sum[i]-(sum[n-1]-sum[i]));
            if (tempVaule<curValue) {
                curCha = tempCha;
                curValue = tempVaule;
            }
//            System.out.println(curValue+" " + curCha);
        }
        System.out.println(curValue+" " + curCha);
    }
}
