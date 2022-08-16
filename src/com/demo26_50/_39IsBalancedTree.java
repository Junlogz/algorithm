package com.demo26_50;

import java.sql.Time;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/8/16 14:10
 */
public class _39IsBalancedTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    // Time:O（nlog(n)） space：O（1）
    public boolean isBalancedTree1(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                isBalancedTree1(root.left) && isBalancedTree1(root.right);
    }

    int getHeightAndCheck(TreeNode root) {
        if (root == null) return 0;

        int left = getHeightAndCheck(root.left);
        if (left == -1) return -1;

        int right = getHeightAndCheck(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    // Time:O（n） space：O（1）
    public boolean isBalancedTree2(TreeNode root) {
        return getHeightAndCheck(root) != -1;
    }

}
