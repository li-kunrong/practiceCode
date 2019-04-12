package LeetCode.array;

/**
 * 167. Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        int tail = numbers.length - 1;
        int head = 0;
        while (head < tail) {
            int sum = numbers[head] + numbers[tail];
            if (sum < target) {
                head++;
            } else if (sum > target) {
                tail--;
            } else {
                int[] res = new int[2];
                res[0] = head + 1;
                res[1] = tail + 1;
                return res;
            }
        }
        return new int[]{-1, -1};

    }
}
