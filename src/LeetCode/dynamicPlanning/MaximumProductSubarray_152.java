package LeetCode.dynamicPlanning;

/**
 * 而对于Product Subarray，要考虑到一种特殊情况，即负数和负数相乘：如果前面得到一个较小的负数，
 * 和后面一个较大的负数相乘，得到的反而是一个较大的数，如{2，-3，-7}，所以，我们在处理乘法的时候，除了需要维护一个局部最大值，
 * 同时还要维护一个局部最小值，由此，可以写出如下的转移方程式：
 *max_copy[i] = max_local[i]
 *max_local[i + 1] = Max(Max(max_local[i] * A[i], A[i]),  min_local * A[i])
 * min_local[i + 1] = Min(Min(max_copy[i] * A[i], A[i]),  min_local * A[i])
 * 写出状态转移方程就解出了
 */
public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        int max_local = nums[0];
        int min_local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max_local;
            max_local = Math.max(Math.max(nums[i] *max_local, nums[i]), nums[i] * min_local);
            min_local = Math.min(Math.min(nums[i] *temp, nums[i]), nums[i] * min_local);
            global = Math.max(global, max_local);
        }
        return global;
    }
}
