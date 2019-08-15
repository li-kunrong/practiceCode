package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/13 10:55
 * @Description:
 **/
public class KdianGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int w = sc.nextInt();
        double res = 0.0;
        double dp[] = new double[k+w];
        for (int i=k; i <= n; i++){
            dp[i] = 1;
        }
        for (int i = n+1; i < k+w; i++) {
            dp[i] = 0;
        }

        double tmp = Math.min(n-k+1,w);
        for (int i = k-1; i>=0; i--) {
            dp[i] = tmp/w;
            tmp+=(dp[i]-dp[i+w]);
        }

        System.out.println(String.format("%.5f",dp[0]));

    }
}
