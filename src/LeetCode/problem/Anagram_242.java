package LeetCode.problem;

/**
 *  if(s.length() != t.length()) return false;
 char[] S = new char[128];
 char[] T = new char[128];
 for(int i = 0; i < s.length(); i++){
 S[s.charAt(i) - '0']++;
 T[t.charAt(i) - '0']++;
 }
 for(int i = 0; i < 128; i++){
 if(S[i] != T[i]) return false;
 }
 return true;
 */
public class Anagram_242 {
    /**
     * 易位构词，字母相同，个数相同，开两个数组判断字母的个数，只要一个不相同，返回false
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] S = new char[128];
        char[] T = new char[128];
        for(int i = 0; i < s.length(); i++){
            S[s.charAt(i) - '0']++;
            T[t.charAt(i) - '0']++;
        }
        for(int i = 0; i < 128; i++){
            if(S[i] != T[i]) return false;
        }
        return true;
    }
}
