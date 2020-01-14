package joy.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x;}

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode ArrayToBalanceTreeNode(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        List<TreeNode> nodes = Arrays.stream(values).map(val -> {
            if (val == null) {
                return null;
            }
            return new TreeNode(val);
        }).collect(Collectors.toList());
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) == null) {
                continue;
            }
            Integer leftIndex = 2*i+1;
            Integer rightIndex = 2*i+2;
            if (leftIndex < nodes.size()) {
                nodes.get(i).left = nodes.get(leftIndex);
            }
            if (rightIndex < nodes.size()) {
                nodes.get(i).right = nodes.get(rightIndex);
            }
        }
        return nodes.get(0);
    }

    public static TreeNode ArrayToTreeNode(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        List<TreeNode> nodes = Arrays.stream(values).map(val -> {
            if (val == null) {
                return null;
            }
            return new TreeNode(val);
        }).collect(Collectors.toList());
        Integer lastUsedIndex = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) == null) {
                continue;
            }
            Integer leftIndex = lastUsedIndex + 1;
            if (leftIndex < nodes.size()) {
                nodes.get(i).left = nodes.get(leftIndex);
                lastUsedIndex += 1;
            }
            Integer rightIndex = lastUsedIndex + 1;
            if (rightIndex < nodes.size()) {
                nodes.get(i).right = nodes.get(rightIndex);
                lastUsedIndex += 1;
            }
        }
        return nodes.get(0);
    }
}
