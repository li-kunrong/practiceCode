package LeetCode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]*/
public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtrack(k,n,nums,0,new ArrayList(),result);
        return result;
    }
    void backtrack(int k, int n, int[] nums,int start, List<Integer> curr, List<List<Integer>> result) {
        if (n> 0) {
            for (int i = start; i <nums.length; i++ ){
                curr.add(nums[i]);
                backtrack(k, n-nums[i],nums,i+1, curr, result);
                curr.remove(curr.size()-1);
            }
        }else if (n == 0 && curr.size() == k) {
            result.add(new ArrayList(curr));
        }
    }
}
