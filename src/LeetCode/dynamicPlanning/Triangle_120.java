package LeetCode.dynamicPlanning;

import java.util.List;
/**
 * 120. Triangle

 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *solution: 从最后一层开始迭代，每层每个与下一层的下和右下比较。
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        int len = triangle.size();
        int []dp = new int[len];
        for (int i = 0;i < len ; i++) {
            dp[i] = triangle.get(len-1).get(i);
        }
        for (int i = len-2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = row.get(j) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}
