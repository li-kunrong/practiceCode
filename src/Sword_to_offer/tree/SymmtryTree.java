package Sword_to_offer.tree;

import java.util.Stack;

public class SymmtryTree {
    /**
     * 思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
     * 左子树的右子树和右子树的左子树相同即可，采用递归
     * 非递归也可，采用栈或队列存取各级子树根节点
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null )
            return true;
        return comRoot(pRoot.left,pRoot.right);
    }

    boolean comRoot(TreeNode left, TreeNode right){
        if (left == null)
            return right == null;
        if (right == null)
            return false;
        if (left.val!= right.val)
            return false;
        return comRoot(left.right,right.left)&&comRoot(left.left,right.right);
    }



    /*
        * DFS使用stack来保存成对的节点
        * 1.出栈的时候也是成对成对的 ，
                   1.若都为空，继续；
                   2.一个为空，返回false;
                   3.不为空，比较当前值，值不等，返回false；
        * 2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.rigth,right.left
        */
    boolean isSymmetricalDFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while(!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
}
