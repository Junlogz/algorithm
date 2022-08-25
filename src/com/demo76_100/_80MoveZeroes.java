package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 283. 移动零
 * Date: 2022/8/24 8:32
 */
public class _80MoveZeroes {

    // Time：O(n), Space：O(1)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                ++slow;
            }
        }
    }

}
