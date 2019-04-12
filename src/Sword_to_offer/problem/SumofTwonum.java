package Sword_to_offer.problem;

import java.util.ArrayList;

public class SumofTwonum {
    /**
     * 二分解决，两个指针
     数列满足递增，设两个头尾两个指针i和j，
     若ai + aj == sum，就是答案（相差越远乘积越小）
     若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
     若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
     O(n)
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) {
            return res;
        }
        int i = 0;
        int j = array.length-1;
        while (i < j){
            if (array[i]+ array[j]== sum){
                res.add(array[i]);
                res.add(array[j]);
                return res;
            }else if (array[i]+array[j] < sum){
                i++;
            }else {
                j--;
            }
        }
        return res;
    }
}
