package interview.nowcode2019.guaziershouche;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 9:30
 * @Description:
 **/
public class Qianshu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = {1,2,5,10};
        int dp[][] = new int[a.length][n+1];
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j*a[0] <= n; j++) {
            dp[0][a[0]*j] = 1;
        }

        for (int i = 1; i < a.length ; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] +=(j-a[i]>=0?dp[i][j-a[i]]:0);
            }
        }
        System.out.println(dp[a.length-1][n]);


    }
}
