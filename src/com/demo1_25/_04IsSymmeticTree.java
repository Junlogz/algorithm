package com.demo1_25;

import java.util.Stack;

/**
 * @author: JunLog
 * @Description: 力扣101.判断二叉树是否对称
 * Date: 2022/8/8 22:16
 */
public class _04IsSymmeticTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean isSymmetric(TreeNode s, TreeNode t) {
        if (s != null && t != null)
            return s.val == t.val &&
                    isSymmetric(s.left, t.right) &&
                    isSymmetric(s.right, t.left);
        else return s == null && t == null;
    }

    // Time：O（n） Space：O（n）递归
    public boolean isSymmetricTreeRecursive(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    // Time：O（n） Space：O（n）
    public boolean isSymmetricTreeIterative(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {
            TreeNode s = stack.pop(), t = stack.pop();
            if (s == null && t == null) return true;
            if (s == null || t == null) return false;
            if (s.val != t.val) return false;

            stack.push(s.left);
            stack.push(t.right);
            stack.push(s.right);
            stack.push(t.left);
        }
        return true;
    }



}
