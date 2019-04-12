package LeetCode.dynamicPlanning;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * blog:https://blog.csdn.net/banbanbanzhuan/article/details/80342110
 * 用动态规划的方法，就是要找到其转移方程式，也叫动态规划的递推式，动态规划的解法无非是维护两个变量，局部最优和全局最优，
 * 我们先来看Maximum SubArray的情况，如果遇到负数，相加之后的值肯定比原值小，但可能比当前值大，也可能小，所以，对于相加的情况，
 * 只要能够处理局部最大和全局最大之间的关系即可，对此，写出转移方程式如下：
 * local[i + 1] = Max(local[i] + A[i], A[i]);
 * global[i + 1] = Max(local[i + 1], global[i]);
 */
public class _53Maxinum_subarray {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int max = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            nums[i] = Math.max(nums[i],nums[i]+nums[i+1]);
            max = Math.max(nums[i],max);
        }
        return max;
    }
}
