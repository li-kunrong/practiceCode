package LeetCode.string;

/**
 * @author kunrong
 * @description:
 * Input: "00110011"
    Output: 6
    Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
    统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
 * @date 2019/3/18 20:31
 */
public class CountBinarySubstrings {
    public static void main(String[] args){
        String s = "00110011";
        System.out.println(new CountBinarySubstrings().countBinarySubstrings(s));
        s.indexOf(4);
    }
    public int  countBinarySubstrings(String s) {
        if (s.length()<=1)
            return 0;
        int res = 0;
        int prelen = 0;
        int currlen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                currlen++;
            }else {
                prelen = currlen;
                currlen = 0;
            }
            if (prelen >= currlen) {
                res++;
            }
        }
        return res;
    }
}
