package interview;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
* 打印二叉树从左视角看到节点
* 给定一颗普通二叉树，请输出二叉树左视角能看到的节点
* 例如，普通二叉树
*                  1
*               /       \
*             2          3
*          /    \      /     \
*         4      5    6       7
*                            /
*                          8
* 从左边看，输出能看到的 1，2，4，8 这四个节点。
* 使用层序遍历,从右到左,然后将最左侧放入结果集中
* */

/**
 * bfs,把每一层的最后一个添加就好。
 */
public class TreeNodeFromLeft {

    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);
        TreeNode root9 = new TreeNode(9);
        root.left= root1;
        root.right = root2;
        root1.left= root3;
        root1.right = root4;
        root2.left = root5;
        root2.right=root6;
        root3.left = root7;
        root3.right= root8;
        root7.left = root9;
        System.out.println(new TreeNodeFromLeft().LeftTree(root));
    }

    public List LeftTree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode tmp = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0) {
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                tmp = queue.poll();
                if (tmp.left != null){
                    queue.add(tmp.left);
                }
                if (tmp.right!= null) {
                    queue.add(tmp.right);
                }
            }
            result.add(tmp.val);
        }

        return  result;
    }
}
