package LeetCode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root." Besides the root,
 * each house has one and only one parent house. After a tour, the smart thief realized that "
 * all houses in this place forms a binary tree". It will automatically contact the police if
 * two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:

 Input: [3,2,3,null,3,null,1]

 3
 / \
 2   3
 \   \
 3   1

 Output: 7
 Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:

 Input: [3,4,5,1,3,null,1]

 3
 / \
 4   5
 / \   \
 1   3   1

 Output: 9
 Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.


 */
public class HouseRobberIII_337 {

    /**
     * 暴力解决超时，因为每次递归总会重复做同样的事
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root ==null)
            return 0;
        int val = 0;
        if (root.left!=null){
            val += rob(root.left.left)+rob(root.left.right);
        }
        if (root.right!=null)
            val+= rob(root.right.left)+rob(root.right.right);
        return Math.max(val+root.val,rob(root.left)+rob(root.right));
    }

    /**
     * 用map来保存已经求过值的，剪枝，可以通过。
     * @param root
     * @return
     */
    public int robII(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    /**
     * dp解决，每个节点都是保存一个数组，res[0]保存的是余下左右节点加起来的总和（可能有左右节点，也可以没有）
     * res[1]保存的是当前的节点加左右的最大值（可以有，可以没有）
     * @param root
     * @return
     */
    public int robIII(TreeNode root) {
        int[] res = robSubI(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSubI(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSubI(root.left);
        int[] right = robSubI(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
