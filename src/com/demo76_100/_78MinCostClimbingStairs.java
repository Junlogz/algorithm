package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 746. 使用最小花费爬楼梯
 * Date: 2022/8/23 15:55
 */
public class _78MinCostClimbingStairs {

    // Time：O(n), Space：O(n)
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int n = cost.length;
        int[] d = new int[n];
        d[0] = cost[0]; d[1] = cost[1];

        for (int i = 2; i < n; i++) {
            d[i] = Math.min(d[i - 1], d[i - 2]) + cost[i];
        }
        return Math.min(d[n - 2], d[n - 1]);
    }

    public int minCostClimbingStairs1(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int first = cost[0], second = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int cur = Math.min(first, second) + cost[i];
            first = second;
            second = cur;
        }
        return Math.min(first, second);
    }



}
