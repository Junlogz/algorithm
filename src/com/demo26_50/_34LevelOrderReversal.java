package com.demo26_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 二叉树逆层序遍历
 * Date: 2022/8/16 10:17
 */
public class _34LevelOrderReversal {

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

        for (int i = 0; i < result.size() / 2; i++) {
            int j = result.size() - 1 - i;
            List<Integer> tmp = result.get(j);
            result.set(j, result.get(i));
            result.set(i, tmp);
        }
        return result;
    }

}
