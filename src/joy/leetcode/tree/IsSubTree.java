package joy.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsSubTree {
    // https://leetcode.com/problems/subtree-of-another-tree/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(s);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (isSameTree(node, t)) {
                return true;
            }
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        } else {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }


}
