package zuoshen.dp.mincore;

/**
 * @Author: kunrong
 * @Date: 2019/8/5 17:13
 * @Description:
 **/
public class Mincoins {
    public static void main(String[] args) {
        int[] arr1 = { 5,4,2,9};
        int aim1 = 2;
        System.out.println(minCoins3(arr1,aim1));
    }
    public static int minCoins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
        }
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }
        int leftup = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                leftup = max;
                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
                    leftup = dp[i - 1][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(leftup, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }
}
