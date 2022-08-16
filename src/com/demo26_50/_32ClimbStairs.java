package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 爬楼梯
 * Date: 2022/8/16 9:38
 */
public class _32ClimbStairs {

    // Time:O（n^2） space：O（1）
    public int climbStairs1(int n) {
        if (n < 2) return 1;
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // Time:O（n） space：O（1）
    public int climbStairs2(int n) {
        int first = 1, second = 1;
        for (int i = 1; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairs3(int n) {
        if(n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n];
    }


}
