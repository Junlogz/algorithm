package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 322. 零钱兑换
 * Date: 2022/8/24 9:58
 */
public class _85CoinChange2 {

    // Time：O(n*sum), Space：O(n*sum)
    public int coinChangeDp(int sum, int[] coins) {
        // 使用前i种面值得硬币，凑成数值j的组合数量
        int[][] d = new int[coins.length + 1][sum + 1];
        for (int j = 0; j <= sum; j++)
            d[0][j] = Integer.MAX_VALUE;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                int userCurCoin = j >= coins[i - 1] ? d[i][j - coins[i - 1]] : Integer.MAX_VALUE;
                if (userCurCoin != Integer.MAX_VALUE) userCurCoin += 1;
                d[i][j] = Math.min(d[i - 1][j], userCurCoin);
            }
        }
        return d[coins.length][sum] == Integer.MAX_VALUE ? -1 : d[coins.length][sum];
    }

//    public int coinChangeDpO1(int sum, int[] coins) {
//        // 使用前i种面值得硬币，凑成数值j的组合数量
//        int[] d = new int[sum + 1];
//        d[0] = 1;
//        for (int i = 1; i <= coins.length; i++) {
//            for (int j = 1; j <= sum; j++) {
//                int userCurCoin = j >= coins[i - 1] ? d[j - coins[i - 1]] : 0;
//                d[j] = d[j] + userCurCoin;
//            }
//        }
//        return d[sum];
//    }

}
