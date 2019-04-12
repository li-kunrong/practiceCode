package LeetCode.tree;
/**
 * 124. Binary Tree Maximum Path Sum

 Given a binary tree, find the maximum path sum.
 For this problem, a path is defined as any sequence of nodes from some starting node to any node
 in the tree along the parent-child connections.

 The path must contain at least one node and does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3

 Return 6.
 */
public class TreeMaxPathSum_124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left),0);//这是为了解决当左右子树为负数时的问题，直接返回当前值就好了。
        int right = Math.max(dfs(root.right),0);

        max = Math.max(max,left+right+root.val);
        return root.val + Math.max(left, right);
    }
}
