package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 判断二叉搜索树
 * Date: 2022/8/18 9:09
 */
public class _44IsValidBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    TreeNode min(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }

    TreeNode max(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }

    // Time:O（n*log(n)） space：O（n）
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        boolean leftValid = root.left == null || root.val > max(root.left).val;
        boolean rightValid = root.right == null || root.val < min(root.right).val;
        return leftValid && rightValid && isValidBST1(root.left) && isValidBST1(root.right);
    }

    // Time:O（n） space：O（n）
    public boolean isValidBST2(TreeNode root) {
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode root, TreeNode lower, TreeNode upper){
        if (root == null) return true;
        if (lower != null && lower.val >= root.val) return false;
        if (upper != null && upper.val <= root.val) return false;
        return isValid(root.left, lower, root) && isValid(root.right, root, upper);
    }

}
