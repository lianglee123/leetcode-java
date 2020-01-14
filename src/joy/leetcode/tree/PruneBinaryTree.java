package joy.leetcode.tree;

public class PruneBinaryTree {
    // https://leetcode.com/problems/binary-tree-pruning/
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode pruneLeft = pruneTree(root.left);
        TreeNode pruneRight = pruneTree(root.right);

        if (isZeroTree(root.left)) {
            root.left = null;
        } else {
            root.left = pruneTree(root.left);
        }

        if (isZeroTree(root.right)) {
            root.right = null;
        } else {
            root.right = pruneTree(root.right);
        }
        return root;
    }

    public boolean isZeroTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return root.val == 0 && isZeroTree(root.left) && isZeroTree(root.right);

    }

}
