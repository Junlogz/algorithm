package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 求盛最多水的容器
 * Date: 2022/8/16 9:31
 */
public class _31MaxWater {

    // Time:O（n） space：O（1）
    public int maxWater(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int cur = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, cur);
            if (height[i] < height[j]) ++i;
            else --j;
        }
        return max;
    }

}
