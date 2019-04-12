package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.

 Example:

 Input:

 4
 /   \
 2     7
 / \   / \
 1   3 6   9

 Output:

 4
 /   \
 7     2
 / \   / \
 9   6 3   1

 Trivia:
 This problem was inspired by this original tweet by Max Howell:

 Google: 90% of our engineers use the software you wrote (Homebrew),
 but you can’t invert a binary tree on a whiteboard so f*** off.


 */
public class InvertBinaryTree_226 {
    /**
     * 递归实现
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /**
     * 为了使程序更加有鲁棒性，自定义栈来实现
     * @param root
     * @return
     */
    public TreeNode invertTreeII(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.poll();
            TreeNode left = node.left;
            node.left= node.right;
            node.right= left;
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * bfs实现
     * @param root
     * @return
     */
    public TreeNode invertTreeIII(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }