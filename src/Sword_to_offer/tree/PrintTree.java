package Sword_to_offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
               res.add(node.val);
            }
        }
        return  res;
    }


}

 class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
         this.val = val;

     }
 }
