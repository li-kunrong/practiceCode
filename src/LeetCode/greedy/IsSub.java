package LeetCode.greedy;

/**
 * @author kunrong
 * @description
 * @date 2019/5/28 14:58
 */
public class IsSub {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
