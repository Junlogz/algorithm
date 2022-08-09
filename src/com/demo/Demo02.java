package com.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: 求和为给定值的两个数的下标
 * Date: 2022/8/8 21:22
 */
public class Demo02 {

    // Time:O(n^2) space：O（1）
    public int[] getTwoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    // Time:O(n) space：O（n）
    public int[] getTwoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numNeed = target - nums[i];
            if (map.containsKey(numNeed)) {
                return new int[] {map.get(numNeed), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
