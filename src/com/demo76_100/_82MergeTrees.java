package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 617. 合并二叉树
 * Date: 2022/8/24 8:46
 */
public class _82MergeTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    // Time：O(n), Space：O(n)
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 != null && t2 == null) return t1;
        if (t2 != null && t1 == null) return t2;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
