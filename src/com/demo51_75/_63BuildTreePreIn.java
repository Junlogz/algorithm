package com.demo51_75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: 从前序与中序遍历序列构造二叉树
 * Date: 2022/8/21 14:06
 */
public class _63BuildTreePreIn {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private TreeNode buildTreeFirst(int[] pre, int preStart, int preEnd, int inStart, Map<Integer, Integer> inPos){
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIdx = inPos.get(pre[preStart]);
        int leftLen = rootIdx - inStart;
        root.left = buildTreeFirst(pre, preStart + 1, preStart + leftLen, inStart, inPos);
        root.right = buildTreeFirst(pre, preStart + leftLen + 1, preEnd, rootIdx + 1, inPos);
        return root;
    }

    // Time：O(n), Space：O(n)
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> inPos = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inPos.put(in[i], i);
        }
        return buildTreeFirst(pre, 0, pre.length - 1, 0, inPos);
    }



}
