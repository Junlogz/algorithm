package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 450. 删除二叉搜索树中的节点
 * Date: 2022/8/25 11:30
 */
public class _92DeleteNode {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    // Time：O(h), Space：O(h)
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            // 说明要删除的是根节点
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // 拿到左子树的最大右节点 然后跟的右子树拼过去
            TreeNode leftMax = root.left;
            while (leftMax.right != null) leftMax = leftMax.right;
            leftMax.right = root.right;
            root = root.left;
        }
        return root;
    }

}
