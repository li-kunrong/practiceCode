package LeetCode.tree;

public class BalancedTree {
    //每个节点都比较查找一次高度，性能低，算法复杂度为O(n^2)
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if (Math.abs(getH(root.left)- getH(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public static int getH(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getH(root.left);
        int right = getH(root.right);
        return Math.max(left, right)+1;
    }
    //改进后复杂度为O（n）
    public boolean isBalanced2(TreeNode root) {
        return getH2(root) != -1;
    }

    private int getH2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getH2(root.left);
        if (left == -1){
            return -1;
        }

        int right = getH2(root.right);
        if (right == -1) {
            return  -1;
        }

        if (Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left,right)+1;
    }


}
