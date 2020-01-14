package joy.leetcode.tree;

public class Others {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    // 这种解决方法错误了，因为对平衡树的的理解错误了
    // 二叉平衡树的定义为：所有节点的左右树的高度差值不超过1，但是为什么这么定义我就不知道了
    public boolean wrongisBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer min = minHeight(root);
        Integer max = maxDepth(root);
        return Math.abs(max - min) <= 1;
    }

    public Integer minHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.min(minHeight(node.left), minHeight(node.right));
    }

    public static int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    // 这种方法自顶向下，所有求heigh时有重复计算。最坏情况下n^2
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer left = maxHeight(root.left);
        Integer right = maxHeight(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
