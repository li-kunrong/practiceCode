package LeetCode.problem;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 Note: You can assume that

 0 <= amount <= 5000
 1 <= coin <= 5000
 the number of coins is less than 500
 the answer is guaranteed to fit into signed 32-bit integer



 Example 1:

 Input: amount = 5, coins = [1, 2, 5]
 Output: 4
 Explanation: there are four ways to make up the amount:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1



 Example 2:

 Input: amount = 3, coins = [2]
 Output: 0
 Explanation: the amount of 3 cannot be made up just with coins of 2.



 Example 3:

 Input: amount = 10, coins = [10]
 Output: 1

 */
public class CoinChange2_518 {
    public static void main(String[] args){
     int num[] = {1,2,5};
        System.out.println(new CoinChange2_518().changeII(5,num));
    }
    int res = 0;

    /**
     * solution
     * dp
     * f[j] = f[j - coins[i]] + f[j] {coins[i] <= j <= amount }
     * 首先对每一个硬币进行遍历
     * 然后+1，现在的加上-coins[j]的，得到最后想要的
     * @param amount
     * @param coins
     * @return
     */
    public static int changeII(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i= 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++)
                dp[j] = dp[j - coins[i]] + dp[j];
        }
        return dp[amount];
    }
    public int change(int amount, int[] coins) {
        if (amount <= 0 || coins == null || coins.length==0){
            return  0;
        }
        Arrays.sort(coins);

        helper(amount,coins.length-1,coins);
        return res;
    }
    void helper(int amount,int i, int[] coins){
        if (i <0){
            return;
        }
        for (int k = i; k>= 0; k--) {
            int tmp = amount-coins[k];
            if (tmp == 0){
                res++;
            }else if (tmp >0){
                helper(tmp,k,coins);
            }

        }
    }

}
