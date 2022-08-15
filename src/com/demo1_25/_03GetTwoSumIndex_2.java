package com.demo1_25;

/**
 * @author: JunLog
 * @Description: 求和为给定值的两个数的下标
 * Date: 2022/8/8 21:22
 */
public class _03GetTwoSumIndex_2 {

    // Time:O（n） space：O（1）
    public int[] getTwoSum1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            // 因为有序的 大的话右边指针左移
            if (nums[i] + nums[j] > target) --j;
            // 小的话左边指针右移
            else if (nums[i] + nums[j] < target) ++i;
            else return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }

}
