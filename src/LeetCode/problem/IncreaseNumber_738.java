package LeetCode.problem;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

 （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

 示例 1:

 输入: N = 10
 输出: 9

 示例 2:

 输入: N = 1234
 输出: 1234

 示例 3:

 输入: N = 332
 输出: 299

 说明: N 是在 [0, 10^9] 范围内的一个整数。

 */
public class IncreaseNumber_738 {
    /**
     * 思路：考虑两种情况：
     * 1. 14339 到4这里发生了翻转，所以把4-1就好
     * 2. 1444339 这里4重复了，所以要一直把相同的继续找下去。
     *
     * step：
     * 1. 从尾部开始
     * 2. 找到发生不合格的数字
     * 3.把后面的都变成9
     * 4.反转部分-1；
     * 5.返回int。
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        String s = Integer.toString(N);
        int index = -1;//记录到哪里不合格了。
        for (int i = s.length()-2; i >= 0; i--) {
            if (s.charAt(i) > s.charAt(i+1) || index!=-1 && s.charAt(i)==s.charAt(index) ){
                index = i;
            }
        }

        return index == -1? N :N - Integer.parseInt(s.substring(index+1,s.length()))-1;//巧妙地减去后面的部分在减一，得到后面的9了。
    }
}
