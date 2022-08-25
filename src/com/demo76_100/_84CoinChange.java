package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 518. 零钱兑换 II
 * Date: 2022/8/24 9:58
 */
public class _84CoinChange {

    // Time：O(n*sum), Space：O(n*sum)
    public int coinChangeDp(int sum, int[] coins) {
        // 使用前i种面值得硬币，凑成数值j的组合数量
        int[][] d = new int[coins.length + 1][sum + 1];
        for (int i = 0; i <= coins.length; i++) {
            d[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                int userCurCoin = j >= coins[i - 1] ? d[i][j - coins[i - 1]] : 0;
                d[i][j] = d[i - 1][j] + userCurCoin;
            }
        }
        return d[coins.length][sum];
    }

    public int coinChangeDpO1(int sum, int[] coins) {
        // 使用前i种面值得硬币，凑成数值j的组合数量
        int[] d = new int[sum + 1];
        d[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                int userCurCoin = j >= coins[i - 1] ? d[j - coins[i - 1]] : 0;
                d[j] = d[j] + userCurCoin;
            }
        }
        return d[sum];
    }

}
