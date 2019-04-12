package LeetCode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.



 For example:
 Given BST [1,null,2,2],

 1
 \
 2
 /
 2



 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space?
 (Assume that the implicit stack space incurred due to recursion does not count).

 */
public class FindModeinBinarySearchTree_501 {
    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    /**
     * 先中序遍历一次，查找到maxCount（最大的共同值长度），然后再初始化modes，再中序遍历一次，和maxcount相同的就写入modes
     * space O(1) ,time O(n)
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        inorder(root);
        currCount=0;
        modes = new int[modeCount];
        modeCount = 0;
        inorder(root);
        return modes;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        handlerValue(root.val);
        inorder(root.right);
    }

    private void handlerValue(int val) {
        if (currVal!=val){
            currVal =val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount){
            maxCount = currCount;
            modeCount=1;
        }else if (currCount == maxCount){
            if (modes!=null)
                modes[modeCount] = val;
            modeCount++;
        }

    }

    Map<Integer, Integer> map;
    int max = 0;

    /**
     * 这个是用map保存最大值，然后再加入数组。
     * space O(n),time O(N)
     * @param root
     * @return
     */
    public int[] findModesII(TreeNode root){
        if(root==null) return new int[0];
        this.map = new HashMap<>();

        inorderII(root);

        List<Integer> list = new LinkedList<>();
        for(int key: map.keySet()){
            if(map.get(key) == max) list.add(key);
        }

        int[] res = new int[list.size()];
        for(int i = 0; i<res.length; i++) res[i] = list.get(i);
        return res;
    }
    private void inorderII(TreeNode node){
        if(node.left!=null) inorder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        max = Math.max(max, map.get(node.val));
        if(node.right!=null) inorder(node.right);
    }


}
