package com.demo51_100;

import java.util.Random;

/**
 * @author: JunLog
 * @Description: 随机洗牌
 * Date: 2022/8/20 11:44
 */
public class _58RandomShuffle {

    int[] nums;
    int[] original;

    public _58RandomShuffle(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    // Time：O(n), Space：O(1)
    public int[] shuffle() {
        Random rnd = new Random();
        for (int i = nums.length - 1; i > 0; --i) {
            int j = rnd.nextInt(i + 1);
            swap(nums, i, j);
        }
        return nums;

    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
