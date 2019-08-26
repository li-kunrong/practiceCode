package interview.baike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/23 20:12
 * @Description:
 **/
public class Chaoyue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sn = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        Arrays.sort(a);
        int sum = 0;
        int i = 0;
        for (; i < n; i++) {
            sum+=a[i];
            if(sum>sn) {
                break;
            }
        }
        System.out.println(i);
    }
}
