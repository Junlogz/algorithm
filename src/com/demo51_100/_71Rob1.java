package com.demo51_100;

/**
 * @author: JunLog
 * @Description: 198. 打家劫舍
 * Date: 2022/8/22 14:21
 */
public class _71Rob1 {

    // Time：O(n), Space：O(n)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] d = new int[nums.length];
        d[0] = nums[0]; d[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + nums[i]);
        }
        return d[nums.length - 1];
    }

    public int robO1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int pre2 = nums[0], pre1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    // Time：O(n), Space：O(1)
    public int robO2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre2 = 0, pre1 = 0;
        for (int num : nums) {
            int cur = Math.max(pre1, pre2 + num);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

}
