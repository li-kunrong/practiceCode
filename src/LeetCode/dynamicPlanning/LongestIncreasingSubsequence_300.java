package LeetCode.dynamicPlanning;

import java.util.TreeSet;

public class LongestIncreasingSubsequence_300 {
    public static void main(String []args){
        int[] nums = {6,2,9,4,7,3,1};
        new LongestIncreasingSubsequence_300().lengthOfLISII(nums);

    }

    /**
     * 链接： https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
     * o（nlog(n))
     *  先开list给已经路过的，然后后来的每一个比list小的都加入去
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    /**
     * 建立一个大小与 nums 长度相等的数组 maxLens，用于记录每个 nums 最长长度，
     * 即 maxLens[i] 表示nums 第 0 个到第 i 个元素中以 nums[i]为最大值的最长子序列长度（注意序列的最后一个值为 nums[i]）：
     * @param nums
     * @return
     */
    public int lengthOfLISII(int[] nums) {
        int[] maxLens = new int[nums.length];
        int maxLen = 0;
        for(int i =0; i < nums.length; i++) {
            for(int j=0; j < i; j++)
                if(nums[i] > nums[j])
                    maxLens[i] = Math.max(maxLens[j]+1, maxLens[i]);
            maxLen = Math.max(maxLen, maxLens[i]+1);
        }
        return maxLen;
    }
    public int lengthOfLISIII(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int num : nums) {
            Integer ceil = set.ceiling(num);
            if(ceil != null) set.remove(ceil);
            set.add(num);
        }
        return set.size();
    }
}
