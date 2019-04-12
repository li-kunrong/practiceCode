package LeetCode.greedy;
/**
 * Created by gouthamvidyapradhan on 02/04/2017.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 * solution:
 * 贪心算法：
 * 这道题时jump game的扩展，貌似默认可以到达，
 * 我们用贪心算法，每次在跳到最大的范围中，寻找最少步骤到达的。
 * 写法很有技巧：
 * step代表步，max表示没个num[i]能到达的最大的jump，，e存储了现在一步所能到达的最大，如果和i相等，再进行一次更新。
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int e = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,i+nums[i]);
            if (i == e) {
                step ++;
                e = max;
            }
        }
        return step;
    }
}
