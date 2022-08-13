package com.demo;

/**
 * @author: JunLog
 * @Description: 连续子序列的最大和
 * Date: 2022/8/12 8:53
 */
public class _21MaxSumOfSubArray {

    //Time:O（n） space：O（1）
    public int maxSumOfSubArray(int[] nums) {
        int max = Integer.MAX_VALUE, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = cur <= 0 ? nums[i] : (cur + nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }


}
