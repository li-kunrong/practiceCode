package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/9 15:51
 * @Description:
 **/
public class FenQian {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i <n; i++) {
            a[i] = scanner.nextInt();
        }
        long sum[] = new long[n];
        sum[0] = a[0];
        for (int i = 1; i < n; i++) {
            sum[i]+=(sum[i-1]+a[i]);
        }
        for (int i = n-2;i>=0;i--) {
            for (int j = i;j<n-1;j++) {
                if(sum[i]==(sum[n-1]-sum[j])){
                    System.out.println(sum[i]);
                    return;
                }else if (sum[i]>sum[n-1]-sum[j]){
                    break;
                }
            }
        }
        System.out.println(0);
    }
}
