package interview.wangyi;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/9 15:21
 * @Description:
 **/
public class Palouti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String num[] = s.split(",");
        int []a = new int[num.length+1];
        for (int i = 0; i < num.length; i++) {
            a[i] = Integer.parseInt(num[i]);
            //System.out.println(a[i]);
        }
        int n = a.length;
        int dp[] = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1]+a[i-1],dp[i-2]+a[i-2]);
        }
        System.out.println(dp[n]);
    }
}
