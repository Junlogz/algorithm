package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 31. 下一个排列
 * Date: 2022/8/29 9:54
 */
public class _97NextPermutation {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Time：O(n), Space：O(1)
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int n = nums.length;
        int p = n - 2;
        while (p >= 0 && nums[p] >= nums[p + 1]) --p;

        if (p >= 0) {
            int i = n - 1;
            while (i > 0 && nums[i] <= nums[p]) --i;
            swap(nums, i, p);
        }

        for (int i = p + 1, j = n - 1; i < j; ++i, --j)
            swap(nums, i ,j);
    }

}
