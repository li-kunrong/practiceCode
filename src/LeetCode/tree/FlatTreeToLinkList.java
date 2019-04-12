package LeetCode.tree;

/**
 * Given a binary tree, flatten it to a linked list in-place.

 For example, given the following tree:

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:

 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */

/**
 * @author kunrong
 * @date 2019/3/4 14:08
 * solution:
 * 寻找左子树的右节点，指向root的右节点，root.right = root.left; root.left = null;
 * 递归完成
 */
public class FlatTreeToLinkList {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode preNode = root.left;
                while (preNode.right!=null) {
                    preNode = preNode.right;
                }
                preNode.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
