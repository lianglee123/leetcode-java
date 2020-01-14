package joy.leetcode.tree;

import java.util.Stack;

public class IsUnivalTree {
    // https://leetcode.com/problems/univalued-binary-tree/submissions/
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return  true;
        }
        Integer val = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (val != node.val) {
                return false;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return true;
    }

}
