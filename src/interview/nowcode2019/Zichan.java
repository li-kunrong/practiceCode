package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/13 14:18
 * @Description:
 **/
public class Zichan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string[] = sc.nextLine().split(",");
        int n = Integer.parseInt(string[0]);
        int type = Integer.parseInt(string[1]);
        String s_size[] = string[2].split(" ");
        String s_value[] = string[3].split(" ");
        int k = s_size.length;
        int a[] = new int[k+1];
        int b[] = new int[k+1];

        for (int i =1 ; i <= k; i++) {
            a[i] = Integer.parseInt(s_size[i-1]);
            b[i] = Integer.parseInt(s_value[i-1]);
        }
        int dp[][] =new int[k+1][n+1];

        for (int i = 1; i <= k; i++) {

            for (int j = 1; j <=n; j++) {
                if (a[i]<=j) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = Math.max(dp[i-1][j-a[i]]+b[i],dp[i][j]);
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(dp[i][j] +" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[k][n]);


    }
}
