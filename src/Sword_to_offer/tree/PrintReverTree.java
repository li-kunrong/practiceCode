package Sword_to_offer.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintReverTree {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(new PrintReverTree().Print(n1));
    }

    /**
     * 两个栈分别存储奇数项和偶数项
     * 算奇数时，s2push left ，然后 push right
     * 算偶数是， s1 push right 然后 push left
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        ArrayList<Integer> list ;
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()||!s2.isEmpty()){
            list = new ArrayList<>();
            if (layer%2==1){

                while (!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    if (node!=null){
                        list.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }

                }
                layer++;
                if (list!=null && list.size()!=0)
                    res.add(list);
            }else{
                while (!s2.isEmpty()){

                    TreeNode node = s2.pop();
                    if (node!=null){
                        list.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }

                }
                layer++;
                if (list!=null&&list.size()!=0)
                    res.add(list);
            }

        }

        return res;
    }
}
