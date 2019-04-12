package Sword_to_offer.tree;

public class FindKsmallTreeNode {
    int index =0;
    TreeNode KthNode(TreeNode root, int k)
    {
        if (root == null)
            return root;
        TreeNode node =  KthNode (root.left,k);
        if (node!=null)
            return node;
        index++;
        if (index==k)
            return root;
        node =  KthNode (root.right,k);
        if (node!=null)
            return node;
        return null;
    }
}
