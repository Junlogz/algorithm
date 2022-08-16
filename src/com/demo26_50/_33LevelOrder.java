package com.demo26_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 二叉树层序遍历
 * Date: 2022/8/16 10:17
 */
public class _33LevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    // Time:O（n） space：O（1）
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> elem = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode s = q.poll();
                elem.add(s.val);
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            result.add(elem);
        }
        return result;
    }

}
