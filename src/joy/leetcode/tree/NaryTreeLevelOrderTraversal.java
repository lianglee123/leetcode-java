package joy.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
//    https://leetcode.com/problems/n-ary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(NaryTree root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<NaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            Integer levelNumber = queue.size();
            for (int i = 0; i < levelNumber; i++) {
                NaryTree node = queue.poll();
                subList.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            result.add(subList);
        }
        return result;
    }

}
