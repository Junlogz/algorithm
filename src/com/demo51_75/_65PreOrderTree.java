package com.demo51_75;

import java.util.*;

/**
 * @author: JunLog
 * @Description: 106. 从中序与后序遍历序列构造二叉树
 * Date: 2022/8/21 14:06
 */
public class _65PreOrderTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    // Time：O(n), Space：O(n)
    public List<Integer> preOrderTree1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    // Time：O(n), Space：O(n)
    public List<Integer> preOrderTree2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return result;
    }


}
