package Sword_to_offer.tree;

import java.util.Stack;

public class BSTconvertToDeque {
    /**
     * 递归算法
     * @param pRoot
     * @return
     */
    public TreeNode Convert(TreeNode pRoot) {
        if(pRoot == null) {
            return null;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return pRoot;
        }
        //左子树生成链表
        TreeNode left = Convert(pRoot.left);
        TreeNode p = left;
        //找出左链表的最后一个
        while (p != null&& p.right!=null){
            p = p.right;
        }
        //连接根节点
        if (left != null){
            p.right = pRoot;
            pRoot.left = p;
        }
        //递归出右链表
        TreeNode right = Convert(pRoot.right);
        //右链表连接根节点
        if (right != null){
            right.left = pRoot;
            pRoot.right = right;
        }
        //返回left或者root；
        return left!=null?left:pRoot;

    }



    // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
    protected TreeNode leftLast = null;
    public TreeNode ConvertII(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null){
            leftLast = root;// 最后的一个节点可能为最右侧的叶节点
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = ConvertII(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = ConvertII(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }


    /**
     * 非递归版
     * @param root
     * @return
     */
    public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }
}
