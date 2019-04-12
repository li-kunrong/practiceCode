package LeetCode.sort;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5

 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 */
public class KthLargestElementinanArray_215 {
    /**
     * https://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 2};
        int p = new KthLargestElementinanArray_215().findKthLargest(a, 3);
        System.out.println(p);
    }

    //快排方法
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }
        int n = nums.length;
        //第k个最大，即是第n-k+1个最小
        return getKth(n - k + 1, nums, 0, n - 1);
    }

    public int getKth(int k, int[] nums, int start, int end) {
        int left = start;
        int right = end;
        int privot = nums[end];//当前的哨兵

        while (true) {
            //小于哨兵的
            while (nums[left] < privot && left < right) {
                left++;
            }
            //大于哨兵的
            while (nums[right] >= privot && left < right) {
                right--;
            }
            if (left == right)
                break;

            swap(nums, left, right);
        }
        //与哨兵交换，使哨兵在left处
        swap(nums, left, end);

        if (k == left + 1) {//哨兵是已经确定位置的，如果left+1==k，就是返回它
            return privot;
        } else if (k < left + 1) {//k的位置比哨兵的位置小，所以在左边找
            return getKth(k, nums, start, left - 1);
        } else {//k的位置比哨兵的位置大，所以在右边找
            return getKth(k, nums, left + 1, end);
        }
    }

    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
    //堆排序的方法
    public int findKthLargestII(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums){
            q.offer(i);
            if (q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }
}