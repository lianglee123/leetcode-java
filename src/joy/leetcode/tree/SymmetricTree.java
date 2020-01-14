package joy.leetcode.tree;

import java.sql.Statement;
import java.util.*;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

    // solution: traversal leftTree in left-> root -> right, rightTree in right-> root -> left
    // compare in traversal, this method is a demo, need optimize
    public boolean isSymmetricIteratively(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list1 = inOrder1(root.left);
        List<Integer> list2 = inOrder2(root.right);
        return list1.equals(list2);

    }

    public List<Integer> inOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
            }
            if (node != null) {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
    public List<Integer> inOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
            }
            if (node != null) {
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return result;
    }
}