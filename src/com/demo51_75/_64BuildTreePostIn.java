package com.demo51_75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: 106. 从中序与后序遍历序列构造二叉树
 * Date: 2022/8/21 14:06
 */
public class _64BuildTreePostIn {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private TreeNode buildTreeFirst(int[] post, int postStart, int postEnd, int inStart, Map<Integer, Integer> inPos){
        if (postStart > postEnd) return null;
        TreeNode root = new TreeNode(post[postEnd]);
        int rootIdx = inPos.get(post[postEnd]);
        int leftLen = rootIdx - inStart;
        root.left = buildTreeFirst(post, postStart, postStart + leftLen - 1, inStart, inPos);
        root.right = buildTreeFirst(post, postStart + leftLen, postEnd - 1, rootIdx + 1, inPos);
        return root;
    }

    // Time：O(n), Space：O(n)
    public TreeNode buildTree(int[] in, int[] post) {
        Map<Integer, Integer> inPos = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inPos.put(in[i], i);
        }
        return buildTreeFirst(post, 0, post.length - 1, 0, inPos);
    }



}
