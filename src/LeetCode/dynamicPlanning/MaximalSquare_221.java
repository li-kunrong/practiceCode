package LeetCode.dynamicPlanning;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 Example:

 Input:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Output: 4


 */
public class MaximalSquare_221 {
    /**
     * 动态规划： 主要思路是从右下角开始，右边和下边有1就1，其他就和dp[i+1][j],dp[i][j+1],dp[i+1][j+1],比较哪个最小，因为
     * 正方形取最小边长。如果它们不相等，那么因为缺失某部分，
     * 而无法构成更大正方形，那么只能取3个正方形中最小的一个加1，为此我们可以得到动态规划递推式：
     * dp[i][j]= min(min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1])+1;
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length ==0){
            return 0;
        }
        int result = 0;
        int length = matrix.length;
        int width = matrix[0].length;
        int [][]dp = new int[length][width];
        for (int i = length-1; i >= 0; i--) {
            for (int j = width-1; j >= 0 ; j--) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }else if (i == length-1 || j == width-1){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]), dp[i+1][j+1])+1;
                }
                result = Math.max(dp[i][j],result);
            }
        }
        return result * result;
    }
}
