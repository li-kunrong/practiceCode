package LeetCode.array;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class RotatedArray_153 {

    public static void main(String[] args) {
        int[] nums = {10, 11, 12, 1, 2, 3, 4, 5, 6, 7};
        new RotatedArray_153().findMin(nums);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int min = nums[0];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2; //计算每次的中点
            min = Math.min(min, nums[mid]);
            if (nums[mid] > nums[left]) {//中点比左边的大，说明min在右边或者min就是nums[0]
                min = Math.min(nums[left], min);
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {//中点比左边的小，说明min在左边。
                right = mid - 1;
            }
        }
        min = Math.min(min, Math.min(nums[left], nums[right]));
        return min;
    }
}
