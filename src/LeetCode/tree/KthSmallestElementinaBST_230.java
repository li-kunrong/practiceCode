package LeetCode.tree;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Example 1:

 Input: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
 2
 Output: 1

 Example 2:

 Input: root = [5,3,6,2,4,null,null,1], k = 3
 5
 / \
 3   6
 / \
 2   4
 /
 1
 Output: 3

 */
public class KthSmallestElementinaBST_230 {
    int k = 0;
    int numOfElements = 0;

    /**
     * 查找排序二叉树中的第k个最小的树，中序遍历，用numOfelements保存路过的数目，当等于target就直接返回
     * @param root
     * @param target
     * @return
     */
    public int kthSmallest(TreeNode root, int target) {
        help(root,target);
        return k;
    }

    private void help(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        help(root.left,target);
        if (++numOfElements == target){
            k = root.val;return;
        }
        help(root.right, target);

    }
}
