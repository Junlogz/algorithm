package com.demo1_25;

/**
 * @author: JunLog
 * @Description: 丢失的数字
 * Date: 2022/8/11 10:12
 */
public class _15MissNum {

    public static void main(String[] args) {
        int[] arr = {3,0,1};
        missingNumber(arr);
    }

    // Time:O（n） space：O（1）
    public static int missingNumber(int[] nums) {
        int n = nums.length, result = n;
        for (int i = 0; i < n; i++) {
            result = result ^ i ^ nums[i];
        }
        return result;
    }

}
