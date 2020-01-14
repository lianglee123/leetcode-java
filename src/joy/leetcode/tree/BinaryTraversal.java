package joy.leetcode.tree;

import java.util.*;

/**
 * https://blog.csdn.net/My_Jobs/article/details/43451187
 * 前序遍历
 * 中序遍历
 * 后续遍历
 * 层次遍历
 * 深度优先
 * 宽度优先
 * 最终放弃了，想一个通用的方法：用显式的栈去替代递归。
 * 主要原因是，递归的隐式栈有个东西是显式的栈很难去实现的：pc_ptr
 * 所以思考这些遍历问题，要用记录路径的思路去理解，而不是去类比程序的隐式栈。
 * <p>
 * // 当时关于递归与栈的思考。
 * 递归其实是一种隐式的入栈出栈操作。
 * 要把递归操作转换为迭代操作，就是把这个隐式的栈变成显示的栈。
 * 递归函数的每次调用都是一次入栈操作，。
 * 递归函数的调用先后顺序和显式入栈顺序是相反的，为啥呢，因为
 * 递归函数中的参数，就是入栈的参数。局部变量，应该使用循环变量替代。
 * 递归函数的每次调用时的参数，都是从stack中pop出来。
 * 递归函数结束的条件：栈空了，入参到达停止边界了。
 * 从栈中弹出一个逻辑，然后进行场景回复。但是显式栈没办法恢复pc_ptr
 */
public class BinaryTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    // root -> left -> right
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                result.add(cur.val);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }

    // root -> left -> right
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // left -> right -> root
    // solution: modify preOrderCode to : root->right->left, and reverse it.
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                result.add(0, cur.val);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }
        return result;
    }

    public static List<Integer> levelTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.ArrayToTreeNode(new Integer[]{1, null, 2, 3});
        assert inorderTraversal(root).equals(Arrays.asList(1, 3, 2)) : "not equal";
    }
}
