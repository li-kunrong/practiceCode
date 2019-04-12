package LeetCode.dynamicPlanning;

import java.util.List;

/**
 * @author kunrong
 * @description
 * @date 2019/3/24 23:29
 */
public class WordBreak {
    /**
     * dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。该问题涉及到字典中单词的使用顺序，因此可理解为涉及顺序的完全背包问题。
     *求解顺序的完全背包问题时，对物品的迭代应该放在最里层。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean b[] = new boolean[n+1];
        b[0] = true;
        for (int i = 1; i <= n; i++ ) {
            for (String str: wordDict) {
                int len = str.length();
                if (len<= i &&str.equals(s.substring(i-len,i))) {
                    b[i]= b[i] ||b[i-len];
                }
            }
        }
        return b[n];
    }
}
