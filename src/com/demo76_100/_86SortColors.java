package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 75. 颜色分类
 * Date: 2022/8/24 13:14
 */
public class _86SortColors {

    // Time：O(n), Space：O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int c0 = 0, c1 = 0, c2 = 0;
        for (int num : nums) {
            if (num == 0) ++c0;
            else if (num == 1) ++c1;
            else ++c2;
        }
        int k = 0;
        for (int i = 0; i < c0; i++) nums[k++] = 0;
        for (int i = 0; i < c1; i++) nums[k++] = 1;
        for (int i = 0; i < c2; i++) nums[k++] = 2;
    }

}
