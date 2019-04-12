package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 113. Path Sum II

 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1

 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allpaths = new ArrayList<>();
        if (root == null) {
            return allpaths;
        }
        dfs(root,new ArrayList(),allpaths,sum);
        return allpaths;
    }
    public void dfs(TreeNode root,List<Integer> path,List<List<Integer>> allpaths,int sum) {
        path.add(root.val);
        if (root.left != null){
            dfs(root.left,path,allpaths,sum-root.val);
        }
        if (root.right != null) {
            dfs(root.right ,path,allpaths,sum-root.val);
        }
        if (root.val == sum && root.left== null && root.right == null) {
            allpaths.add(new ArrayList(path));
        }
        //记得移除
        path.remove(path.size()-1);
    }
}
