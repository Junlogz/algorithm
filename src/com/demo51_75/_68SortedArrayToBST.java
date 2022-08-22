package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 108. 将有序数组转换为二叉搜索树
 * Date: 2022/8/22 11:53
 */
public class _68SortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    // Time：O(n), Space：O(log(n))
    public TreeNode arrayToBST(int[] nums) {
        if (nums == null && nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

}
