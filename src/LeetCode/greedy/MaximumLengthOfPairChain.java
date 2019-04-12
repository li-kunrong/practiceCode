package LeetCode.greedy;

import java.util.Arrays;

/**
 * @author kunrong
 * @date 2019/2/24 14:27
 */
/**
 * Created by gouthamvidyapradhan on 01/05/2018.
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c.
 Chain of pairs can be formed in this fashion.
 Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs.
 You can select pairs in any order.
 Example 1:
 Input: [[1,2], [2,3], [3,4]]
 Output: 2
 Explanation: The longest chain is [1,2] -> [3,4]
 Note:
 The number of given pairs will be in the range [1, 1000].
 Solution: O(N log N) sort the pairs with ending interval (greedy sort) and try to accommodate as many pairs
 as possible. If any current pair violates the chaining condition (b < c) then, ignore that particular pair.
 *
 * 重点在于怎么排序，先比较后面的数，在此基础上比较前面的数，
 */
public class MaximumLengthOfPairChain {
    public static void main(String[] args){
        int[][] A = {{1,2}, {2,3}, {4,5},{6,7},{3,9}};
        System.out.println(new MaximumLengthOfPairChain().findLongestChain(A));
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs== null || pairs.length == 0) {
            return 0;
        }
        int count = 1;
        Arrays.sort(pairs,(o1,o2) -> (o1[1] == o2[1])? Integer.compare(o1[0],o2[0]): Integer.compare(o1[1],o2[1]));

        int []curr = pairs[0];
        for (int i = 1;i < pairs.length; i++) {
            if (pairs[i][0] > curr[1]) {
                curr = pairs[i];
                count++;
            }
        }
        return count;
    }

}
