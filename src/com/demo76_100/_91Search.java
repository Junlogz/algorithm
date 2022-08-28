package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 33. 搜索旋转排序数组
 * Date: 2022/8/25 10:55
 */
public class _91Search {

    // Time：O(log(n)), Space：O(1)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && target >= nums[low]) high = high - 1;
                else low = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

}
