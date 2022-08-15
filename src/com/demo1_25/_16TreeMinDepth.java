package com.demo1_25;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 求二叉树最小深度
 * Date: 2022/8/11 10:53
 */
public class _16TreeMinDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    // Time:O（n） space：O（n）递归
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth1(root.right) + 1;
        if (root.right == null) return minDepth1(root.left) + 1;
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }

    // Time:O（n） space：O（n）队列
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode s = q.poll();
                if (s.left == null && s.right == null) return depth;
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            ++depth;
        }
        return -1;
    }

}
