package Sword_to_offer.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOftheTree {

    /**
     * 层次遍历，每一层就++；
     * @param pRoot
     * @return
     */
    public int TreeDepth(TreeNode pRoot)
    {
        if(pRoot == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int depth = 0, count = 0, nextCount = 1;
        while(queue.size()!=0){
            TreeNode top = queue.poll();
            count++;
            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }


    /**
     * 递归遍历
     * @param pRoot
     * @return
     */
    public int TreeDepthII(TreeNode pRoot)
    {
        if(pRoot == null){
            return 0;
        }
        int left = TreeDepthII(pRoot.left);
        int right = TreeDepthII(pRoot.right);
        return Math.max(left, right) + 1;
    }
}
