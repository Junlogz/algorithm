package com.demo26_50;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: JunLog
 * @Description: 二叉树中序遍历
 * Date: 2022/8/16 10:57
 */
public class _35InorderTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    // Time:O（n） space：O（n）
    public List<Integer> inorderTree1(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> left = inorderTree1(root.left);
        List<Integer> right = inorderTree1(root.right);

        left.add(root.val);
        left.addAll(right);
        return left;
    }

    // Time:O（n） space：O（n）
    public List<Integer> inorderTree2(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (root != null || !s.empty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}
