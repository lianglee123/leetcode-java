package joy.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryTreeTraversal {
    // root -> children(left -> right)
    public List<Integer> preorder(NaryTree root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<NaryTree> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            root = stack.peek();
            list.add(root.val);
            if (root.children != null) {
                for (int i = root.children.size()-1; i >= 0; i--) {
                    stack.add(root.children.get(i));
                }
            }
        }
        return list;
    }

    // children(left -> right) -> root
    // solution:
    // 1. modify preorder code to： root -> children(right->left)
    // 2. reverse the result
    public List<Integer> postorder(NaryTree root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<NaryTree> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            root = stack.pop();
            list.add(0, root.val);
            if (root.children != null) {
                stack.addAll(root.children);
            }

        }
        return list;
    }

}
