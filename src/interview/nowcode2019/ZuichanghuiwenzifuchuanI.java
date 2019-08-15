package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 10:33
 * @Description:
 **/
public class ZuichanghuiwenzifuchuanI {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        String s1 = s.next();
        char[] c = s1.toCharArray();
        int n = c.length;
        int dp[][] = new int[n][n];
        for (int r = 0; r < n; r++) {
            dp[r][r] = 1;
            for (int l = r-1; l>=0; l--) {
                if (c[l]==c[r]){
                    dp[l][r] = dp[l+1][r-1]+2;
                }else {
                    dp[l][r] = Math.max(dp[l+1][r],dp[l][r-1]);
                }
            }
        }

        System.out.println(dp[0][n-1]);

    }
}
