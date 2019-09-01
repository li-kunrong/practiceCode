package interview.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/8/11 14:38
 */
public class Second {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int n = scanner.nextInt();
        int a[] = new int[n];
        int []lens = new  int[l];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            lens[a[i]] = 1;
        }
        Arrays.sort(a);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <l; i++) {
//            int tmp = solve(a,i,lens);
//            if (tmp<res)
//                res = tmp;
        }

        System.out.println(res);




    }

}
