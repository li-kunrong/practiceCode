package interview.nowcode2019.shopee;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/14 11:38
 * @Description:
 **/
public class FirstII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int n = scanner.nextInt();
        long [][]dp = new long[x+1][y+1];

        for (int i = 0; i < n;i++) {
            int tempx = scanner.nextInt();
            int tempy = scanner.nextInt();
            dp[tempx][tempy] = -1;
        }
        for (int i = 0; i <= x; i++) {
            if (dp[i][0] != -1) {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j <= y; j++) {
            if (dp[0][j]!=-1) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (dp[i][j]!=-1) {
                    long t = dp[i-1][j]==-1?0:dp[i-1][j];
                    long u = dp[i][j-1]==-1?0:dp[i][j-1];
                    dp[i][j] = t+u;
                }
            }
        }
        System.out.println(dp[x][y]);
    }
}
