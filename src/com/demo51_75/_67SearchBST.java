package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 二叉搜索树中的查找数字
 * Date: 2022/8/22 11:28
 */
public class _67SearchBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    // Time：O(h), Space：O(n)
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || val == root.val)  return root;
        else if (val < root.val) return searchBST1(root.left, val);
        else return searchBST1(root.right, val);
    }

    // Time：O(h), Space：O(n)
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && val != root.val) {
            if (val < root.val) root = root.left;
            else root = root.right;
        }
        return root;
    }



}
