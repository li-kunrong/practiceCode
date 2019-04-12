package LeetCode.tree;

/**
 * @author kunrong
 * @date 2019/2/23 23:08
 */
public class SumofLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{

    }

    public int sumOfLeftLeaves(TreeNode root) {
        return inorder(root,false);
    }

    private int inorder(TreeNode node , boolean isLeft) {
        if (node!= null) {
            if(node.left== null && node.right == null) {
                if (isLeft == true) {
                    return node.val;
                }else {
                    return 0;
                }
            }
            return  inorder(node.left,true) + inorder(node.right,false);
        }
        return 0;
    }
}
