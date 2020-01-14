package joy.leetcode.tree;

public class IsBalance {
    // 这种解决方法错误了，因为对平衡树的的理解错误了
    // 二叉平衡树的定义为：所有节点的左右树的高度差值不超过1，但是为什么这么定义我就不知道了
    public boolean wrongisBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer min = minHeight(root);
        Integer max = maxHeight(root);
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

    public static int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    // 自底向下，一旦有发现不平衡的子树，立即停止计算(return -1)
    public static boolean isBalance2(TreeNode root) {
        return dfsHeight(root) != -1;
    }
}
