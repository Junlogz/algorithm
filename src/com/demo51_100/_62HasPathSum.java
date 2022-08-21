package com.demo51_100;

import java.util.Stack;

/**
 * @author: JunLog
 * @Description: 112. 路径总和
 * Date: 2022/8/21 12:36
 */
public class _62HasPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    // Time：O(n), Space：O(n)
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

    // Time：O(n), Space：O(n)
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(root);
        sumStack.push(sum);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            int s = sumStack.pop();
            if (n.left == null && n.right == null && n.val == s) return true;
            if (n.left != null) {
                stack.push(n.left); sumStack.push(s - n.val);
            }
            if (n.right != null) {
                stack.push(n.right); sumStack.push(s - n.val);
            }
        }
        return false;
    }

}
