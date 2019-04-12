package LeetCode.problem;

import LeetCode.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeandDeserializeBinaryTree {
    /**
     * 投机取巧的方式
     */
    TreeNode head;
    public String serialize(TreeNode root) {
        head = root;
        return "";
    }


    public TreeNode deserialize(String data) {
        return head;
    }

    /**
     * 前序遍历拆树，用队列绑蔓建树，也是前序遍历
     *
     */
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serializeI(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserializeI(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
