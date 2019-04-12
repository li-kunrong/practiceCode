package LeetCode.dynamicPlanning;

/**
 * @author kunrong
 * @description
 * @date 2019/3/26 15:54
 */
public class PartitionEqualsSubsetSum {
    /**
     * 划分数组为和相等的两部分
     * solution： 先判断sum的奇偶性
     * 从和的一半开始计算，如果可以把dp[mid]变成true，就是可以有数字达到目的
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum%2!=0)
            return false;
        int mid = sum/2;
        boolean dp[] = new boolean[mid+1];
        dp[0] = true;
        for (int x:nums) {
            for (int i = mid; i >=x; i--) {
                dp[i] = dp[i] || dp[i-x];
            }
        }
        return dp[mid];

    }

    public static int getSum(int []nums) {
        int res = 0;
        for (int i:nums)
            res+=i;
        return res;
    }
}
