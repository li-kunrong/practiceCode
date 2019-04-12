package Sword_to_offer.tree;

public class InOrderNext {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e
     来源：牛客网

     思路：

     （1） 若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点 B ）

     （2） 若该节点不存在右子树：这时分两种情况：

     2.1 该节点为父节点的左子节点，则下一个节点为其父节点（如图节点 D ）

     2.2 该节点为父节点的右子节点，则沿着父节点向上遍历，知道找到一个节点的父节点的左子节点为该节点，
     则该节点的父节点下一个节点（如图节点 I ，沿着父节点一直向上查找找到 B （ B 为其父节点的左子节点），则 B 的父节点 A 为下一个节点）
     * @param node
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode node)
    {
        if (node == null)
            return node;
        if (node.right != null){//如果有右子树，寻找右子树的最左节点
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        }
        while (node.next != null){//右子树不存在，若为左子树，直接返回父节点，若为右子树，则继续通过父节点，知道该节点为左子树，返回该节点的父节点
            if (node.next.left == node)
                return node.next;
            node = node.next;
        }
        return null;//到了根，返回null
    }
}

 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
