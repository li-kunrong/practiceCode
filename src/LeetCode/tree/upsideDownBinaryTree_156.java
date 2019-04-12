package LeetCode.tree;
/**
 * 156. Binary Tree Upside Down
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
 1
 / \
 2  3
 / \
 4   5

 return the root of the binary tree [4,5,2,#,#,3,1].
 4
 / \
 5  2
 / \
 3  1

 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class upsideDownBinaryTree_156 {
    /**
     * 思路: 题意是说每个结点的右子树要么为空, 要么一定有一个左子树孩子和一个右子树孩子, 因此树的形状是左偏的.
     * 所以我们要将最左边的子树作为最终的新根结点, 然后递归的将其父结点作为其右孩子,并且父结点的右孩子作为其左孩子.
     * 一个非常重要的地方是每次一定要将父结点的左右孩子都置为空, 因为父结点设置成其左孩子的右孩子之后成了叶子结点, 需要将其指针断掉.
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode newroot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newroot;
    }
}
