package LeetCode.dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.

 Example 1:

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".

 Example 2:

 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.

 Example 3:

 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output: false


 */
public class Word_Break_139 {
    /**
     * dfs,先判断是否startwith，然后，再减掉深搜，map用来保存肯定不可以的。
     */
    Set<String> map = new HashSet();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        if (map.contains(s))
            return false;
        for (String word: wordDict){
            if (s.startsWith(word)){
                if(wordBreak(s.substring(word.length(),s.length()),wordDict)){
                    return true;
                }
            }
        }
        map.add(s);
        return false;
    }
}
