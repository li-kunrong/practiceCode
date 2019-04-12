package LeetCode.problem;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1:

 Input: [3,0,1]
 Output: 2

 Example 2:

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 */
public class MissNUmber_268 {
    /**
     * 寻找迷失的数字
     * 正常想法开个数组存储，然后有的q1，再次遍历
     * 然后发现可以直接求和，然后减去得到结果。
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = (0+nums.length)*(nums.length+1)/2;
        for (int i:nums)
            sum-=i;
        return sum;
    }
}
