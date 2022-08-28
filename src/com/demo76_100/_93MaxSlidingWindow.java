package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 239. 滑动窗口最大值
 * Date: 2022/8/25 14:03
 */
public class _93MaxSlidingWindow {

    // Time：O(n), Space：O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] maxFromLeft = new int[n];
        int[] maxFromRight = new int[n];
        maxFromLeft[0] = nums[0];
        maxFromRight[n - 1] = nums[n - 1];

        for (int i = 1, j = n - 2; i < n; ++i, --j) {
            maxFromLeft[i] = i % k == 0 ? nums[i] : Math.max(maxFromLeft[i - 1], nums[i]);
            maxFromRight[j] = j % k == k - 1 ? nums[j] : Math.max(maxFromRight[j + 1], nums[j]);
        }

        for (int i = 0; i <= n - k; ++i) {
            result[i] = Math.max(maxFromRight[i], maxFromLeft[i + k -1]);
        }
        return result;
    }

}
