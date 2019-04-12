package Sword_to_offer.tree;

public class IsBalanceTree {
    /**
     * 判断左子树-右子树是否大于1
     * 小于1就返回1+Max（left+right)
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        if (left == -1)
            return -1;
        int right = getDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left-right)>1?-1:1+Math.max(left,right);
    }
}
