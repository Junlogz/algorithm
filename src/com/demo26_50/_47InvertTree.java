package com.demo26_50;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 翻转二叉树
 * Date: 2022/8/18 10:25
 */
public class _47InvertTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    // Time:O（n） space：O（n）
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    // Time:O（n） space：O（n）
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (root.left != null) q.add(root.left);
            if (root.right != null) q.add(root.right);
        }
        return root;
    }
}
