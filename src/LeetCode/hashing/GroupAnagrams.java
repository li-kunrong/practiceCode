package LeetCode.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * desription:
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.

 *solution: 数组存放字母的出现的次数，用字符串记录并且作为HashMap 的key，然后把key相同的放到同一个list中，然而返回
 * 的是list，所以再遍历keyset，
 */
public class GroupAnagrams {
    private int[] A = new int[256];
    private HashMap<String, List<String>> hashMap = new HashMap<>();
    private List<List<String>> result = new ArrayList<>();

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);
        for (List<String> l : result) {
            for (String s : l)
                System.out.println(s);
            System.out.println("-----");
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 0, l = strs.length; i < l; i++) {
            Arrays.fill(A, 0);
            String s = strs[i];
            for (int j = 0, sl = s.length(); j < sl; j++)
                A[s.charAt(j)]++;

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 256; k++) {
                if (A[k] != 0)
                    sb.append(k).append("").append(A[k]);
            }
            List<String> value = hashMap.get(sb.toString());
            if (value == null)
                value = new ArrayList<>();
            value.add(s);
            hashMap.put(sb.toString(), value);
        }

        for (String s : hashMap.keySet()) {
            result.add(hashMap.get(s));
        }


        return result;
    }
}
