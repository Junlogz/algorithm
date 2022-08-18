package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 股票最大利润
 * Date: 2022/8/18 10:03
 */
public class _46StockMaxProfit {

    // Time:O（n^2） space：O（n）
    public int stockMaxProfit1(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    // Time:O（n） space：O（n）
    public int stockMaxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) buy = prices[i];
            else maxProfit = Math.max(maxProfit, prices[i] - buy);
        }
        return maxProfit;
    }

    // 动规 Time:O（n） space：O（n）
    public int stockMaxProfit3(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

}
