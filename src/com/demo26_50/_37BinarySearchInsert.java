package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 二分搜索
 * Date: 2022/8/16 11:22
 */
public class _37BinarySearchInsert {

    // Time:O（log(n)） space：O（1）
    public int binarySearch(int[] nums, int target) {
        if (nums == null) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) high = mid - 1;
            else if (target > nums[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }

}
