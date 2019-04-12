package LeetCode.dynamicPlanning;

/**
 * @author kunrong
 * @description
 * @date 2019/3/19 20:40
 */
public class MinSubPath {
    public static void main(String[] args){
        int[][] arr ={{1,3,1},{1,5,1},{4,2,1}};
        //System.out.println(new MinSubPath().minSubPath(arr));
        System.out.println(new MinSubPath().minPathSum(arr));
    }
    public int minSubPath(int[][] array) {
        if (array == null || array.length== 0)
            return 0;
        int dp[][] = new int[array.length][array[0].length];
        dp[0][0] = array[0][0];
        for (int i = 1; i < array[0].length; i++)
            dp[0][i]=array[0][i]+dp[0][i-1];
        for (int i = 1; i < array.length; i++)
            dp[i][0] =dp[i-1][0]+ array[i][0];

        for (int i = 1; i < array.length; i++) {
            for (int j= 1; j < array[0].length; j++) {
                dp[i][j]= Math.min(dp[i-1][j], dp[i][j-1])+array[i][j];
            }
        }
        show(dp);
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void show(int[][] a) {
        for (int i = 0;i < a.length; i++) {
            for (int j= 0; j< a[0].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j];        // 只能从上侧走到该位置
                } else if (i == 0) {
                    dp[j] = dp[j - 1];    // 只能从左侧走到该位置
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
