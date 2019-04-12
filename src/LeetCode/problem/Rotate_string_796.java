package LeetCode.problem;

/**
 * 给定两个字符串, A 和 B。

 A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
 如果在若干次旋转操作之后，A 能变成B，那么返回True。

 示例 1:
 输入: A = 'abcde', B = 'cdeab'
 输出: true

 示例 2:
 输入: A = 'abcde', B = 'abced'
 输出: false
 */
public class Rotate_string_796 {
    /**
     * 读懂题目后，运用String的方法顺利拿下
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()){
            return false;
        }
        if (A.length() == 0 && B.length() == 0) {
            return true;
        }
        for(int i = 0; i < A.length(); i++) {
            if ((A.substring(i) + A.substring(0,i)).equals(B)){
                return true;
            }
        }
        return false;
    }
}
