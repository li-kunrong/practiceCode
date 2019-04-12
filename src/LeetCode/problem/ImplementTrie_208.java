package LeetCode.problem;

import java.util.HashMap;

/**
 * 前缀树
 * Implement a trie with insert, search, and startsWith methods.

 Example:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true

 Note:

 You may assume that all inputs are consist of lowercase letters a-z.
 All inputs are guaranteed to be non-empty strings.


 */
public class ImplementTrie_208 {
}

class Trie {
    private HashMap<Character,Trie> mp ;
    private boolean isStep;
    /** Initialize your data structure here. */
    public Trie() {
        this.mp = new HashMap<>();
        this.isStep = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for (Character c : word.toCharArray()){
            if (!curr.mp.containsKey(c)){
                curr.mp.put(c,new Trie());
            }
            curr = curr.mp.get(c);
        }
        curr.isStep = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchHelper(word,this, true);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchHelper(prefix,this, false);
    }

    public boolean searchHelper(String word, Trie ire,boolean partial) {
        for (Character c: word.toCharArray()) {
            if (!ire.mp.containsKey(c)) {
                return false;
            }
            ire = ire.mp.get(c);
        }
        if (partial == true) {
            return ire.isStep;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
