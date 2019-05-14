package interview.meituan;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/21 21:16
 */
public class Gonggongzichuan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
      //  System.out.println(s1+" " + s2);
        System.out.println(getRes(s1,s2));
    }
    static int getRes(String s1, String s2) {
        int res = 0;
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int[][] dp = new int[c1.length][c2.length];
        for (int i = 0; i < c1.length; i++) {
            if (c1[i]==c2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < c2.length; j++) {
            if (c2[j] == c1[0])
                dp[0][j] = 1;

        }
        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j <c2.length; j++) {
                if (c1[i] == c2[j])
                    dp[i][j]+=dp[i-1][j-1]+1;
                else
                    dp[i][j] = 0;
            }
        }
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j <c2.length; j++){
                if (dp[i][j]>res)
                    res = dp[i][j];
            }
        }
        return res;
    }
}
