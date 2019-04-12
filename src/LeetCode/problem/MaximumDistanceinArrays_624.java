package LeetCode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  * 624. Maximum Distance in Arrays
 *
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one)
 * and calculate the distance. We define the distance between two
 * integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

 Example 1:
 Input:
 [[1,2,3],
 [4,5],
 [1,2,3]]

 Output: 4

 Explanation:

 One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.

 Note:
 Each given array will have at least 1 number. There will be at least two non-empty arrays.
 The total number of the integers in all the m arrays will be in the range of [2, 10000].
 The integers in the m arrays will be in the range of [-10000, 10000].
 */
public class MaximumDistanceinArrays_624 {

    public static void main(String[] args) {
        int []a = {1,2,3};
        int []b = {4,5};
        int []c = {1,2,3,4,6};
        int []d = {2,3};
        int [][]e = {{1,2,3,9},{4,5},{1,2,3,4,5},{2,3}};
        new MaximumDistanceinArrays_624().maxDistanceII(e);
    }
    /**
     * 由于是比较两个数组的最大差，所以注意不要找到同一数组的
     * 每次更新res，然后更新当前的最大值和最小值。
     * @param arrays
     * @return
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min = arrays.get(0).get(0);
        int res = 0;
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(Math.abs(min-arrays.get(i).get(arrays.get(i).size()-1)),Math.max(Math.abs(max-arrays.get(i).get(0)),res));
            min = Math.min(min,arrays.get(i).get(0));
            max = Math.max(max,arrays.get(i).get(arrays.get(i).size()-1));
        }

        return res;
    }

    public int maxDistanceII(int[][] arrays) {
        List<Integer> max = new ArrayList<>();
        for (int[] array : arrays) {
            max.add(array[array.length - 1]);
        }
        System.out.println(max);
        //得到的max是每个数组的最大值，而且排好序
        Collections.sort(max);
        System.out.println(max);
        int ans = Integer.MIN_VALUE;
        for (int[] array : arrays) {
            //若是统一数组的，则拿第二最大的。
            int big = array[array.length - 1] == max.get(max.size() - 1) ?
                    max.get(max.size() - 2) : max.get(max.size() - 1);
            ans = Math.max(ans, big - array[0]);
        }
        return ans;
    }
}
