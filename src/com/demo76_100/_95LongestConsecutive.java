package com.demo76_100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: JunLog
 * @Description: 128. 最长连续序列
 * Date: 2022/8/28 20:28
 */
public class _95LongestConsecutive {

    // Time：O(n*log(n)), Space：O(1)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 0, p = 0;

        while (p < nums.length) {
            int len = 1;
            while (p < nums.length - 1) {
                if (nums[p + 1] - nums[p] > 1) break;
                if (nums[p + 1] - nums[p] == 1) ++len;
                ++p;
            }
            max = Math.max(max, len);
            ++p;
        }
        return max;
    }

    // Time：O(n), Space：O(n)
    public int longestConsecutive1(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int num : nums) hash.add(num);
        int res = 0;
        for (int x : hash) {
            if (hash.contains(x - 1)) {
                int y = x;
                while (hash.contains(y + 1)) y++;
                res = Math.max(res, y - x + 1);
            }
        }
        return res;
    }



}
