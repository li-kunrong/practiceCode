package LeetCode.dynamicPlanning;

import java.util.Arrays;

/**
 * @author kunrong
 * @description
 * @date 2019/3/19 21:03
 */
public class UniquePaths {
    public static void main(String[] args){

        System.out.println(new UniquePaths().uniquePaths(3,3));
    }
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}

