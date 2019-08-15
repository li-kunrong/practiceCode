package interview.kuaishou;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/8 14:34
 * @Description:
 **/
public class Mofashengyuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = {1,2,4,8,16,32,64,128,256,512};
        int q = 0;
        int[]dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i < a.length; i++) {
            dp[a[i]]=1;
        }
        for (int i = 3; i <= 1000; i++) {
            int j = 0;
            while (j<a.length&&i-a[j]>=0) {
                dp[i]=(dp[i]+dp[i-a[j]])%(1000000003);
                j++;
            }
        }
//        for (int i = 1; i <= 1000; i++) {
//            System.out.println(dp[i]);
//        }
        for (int i = 0; i < n; i++) {
            q = scanner.nextInt();
            System.out.println(dp[q]);
        }



    }
}
