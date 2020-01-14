package joy.leetcode.tree;

public class MinimunDepth {
    // 第一遍做错了，因为没有理解题意
    // https://leetcode.com/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }

}
