package LeetCode.two_points;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]

 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.


 */
public class MoveZeroes_283 {
    /**
     * 双指针问题，
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while ( fast < nums.length) {
            if (nums[fast] !=0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }

    }
}
