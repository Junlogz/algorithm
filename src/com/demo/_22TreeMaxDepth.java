package com.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 求二叉树最大深度
 * Date: 2022/8/11 10:53
 */
public class _22TreeMaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    // Time:O（n） space：O（n）递归
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    // Time:O（n） space：O（n）队列
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode s = q.poll();
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            ++depth;
        }
        return depth;
    }

}
