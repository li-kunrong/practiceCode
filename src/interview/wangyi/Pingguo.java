package interview.wangyi;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/3/29 14:46
 */
public class Pingguo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n+1];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        int m = scanner.nextInt();
        int q[] = new int[m+1];
        for (int i = 0; i < m; i++)
            q[i] = scanner.nextInt();

        int sum[] = new int[n];
        sum[0] = a[0];
        for (int i = 1; i < n; i++){
            sum[i]=sum[i-1] + a[i];
        }

        for (int i = 0; i < m; i++) {
            find(q[i],sum);
        }
    }

    public static void find(int target, int[]a) {
        int left = 0;
        int right = a.length-1;
        while (left<=right) {
            int mid = (left+right)/2;
            if (a[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        System.out.println(left+1);
    }
}
