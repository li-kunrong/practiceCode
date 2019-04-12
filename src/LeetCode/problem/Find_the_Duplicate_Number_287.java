package LeetCode.problem;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n
 * (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.

 Example 1:

 Input: [1,3,4,2,2]
 Output: 2

 Example 2:

 Input: [3,1,3,4,2]
 Output: 3

 Note:

 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.


 */

/**
 * 这道题是求数组中只有一个的重复的数字，明眼人都知道用map，但空间O（1),orz,所以转化为链表寻找环的入口那道题，题解在
 * https://leetcode.com/problems/find-the-duplicate-number/discuss/72845/Java-O(n)-time-and-O(1)-space-solution.-Similar-to-find-loop-in-linkedlist.
 */
public class Find_the_Duplicate_Number_287 {
    /**
     * uppose the array is

     index: 0 1 2 3 4 5

     value: 2 5 1 1 4 3

     first subtract 1 from each element in the array, so it is much easy to understand.
     use the value as pointer. the array becomes:

     index: 0 1 2 3 4 5

     value: 1 4 0 0 3 2

     enter image description here

     Second if the array is

     index: 0 1 2 3 4 5

     value: 0 1 2 4 2 3

     we must choose the last element as the head of the linked list. If we choose 0, we can not detect the cycle.

     Now the problem is the same as find the cycle in linkedlist!
     * @param nums
     * @return
     */
    /**
     * 这里还是修改了数组
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = n-1;
        int fast = n-1;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = n-1;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow+1;
    }

    /**
     * 唯一正解
     * @param nums
     * @return
     */
    public int findDuplicateII(int[] nums) {
        int n = nums.length;
        for(int i=0;i<nums.length;i++) nums[i]--;
        int slow = n;
        int fast = n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }

    /**
     * 空间O(n)
     * 但也不失为一个方法。（虽然依然不符合）
     * @param nums
     * @return
     */
    public int findDuplicateIII(int[] nums) {
        if(nums.length <1) return -1;
        int[] arr = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i] - 1] == 1) return nums[i];
            arr[nums[i] - 1] = 1;
        }
        return -1;
    }
}
