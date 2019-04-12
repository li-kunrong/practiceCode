package Sword_to_offer.problem;

public class MostMaxSequence {
    /**
     * dp[i] = max(dp[i-1]+array[i],array[i])
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] clone = new int[array.length];
        clone[0] = array[0];
        int res = clone[0];
        for (int i = 1; i < array.length; i++) {
            clone[i] = Math.max(array[i], array[i] + clone[i - 1]);
            if (clone[i] > res)
                res = clone[i];
        }
        return res;
    }
}
