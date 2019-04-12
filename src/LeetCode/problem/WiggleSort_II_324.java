package LeetCode.problem;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example 1:

 Input: nums = [1, 5, 1, 1, 6, 4]
 Output: One possible answer is [1, 4, 1, 5, 1, 6].

 Example 2:

 Input: nums = [1, 3, 2, 2, 3, 1]
 Output: One possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?

 */
public class WiggleSort_II_324 {
    public static void main(String []args) {

        int []nums = {1,3,9,2,5,6,8,4};
        new WiggleSort_II_324().wiggleSort(nums);
    }

    /**
     * 时间O(nlog(n)), 空间O(n),所以还是看大神的吧，
     * https://leetcode.com/problems/wiggle-sort-ii/discuss/77684/Summary-of-the-various-solutions-to-Wiggle-Sort-for-your-reference
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        for (int i = m - 1, j = 0; i >= 0; i--, j += 2)
            nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2)
            nums[j] = copy[i];
    }
}
