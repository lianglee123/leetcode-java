package joy.leetcode.dp;

public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        int maxSumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxSumProfit += profit;
            }
        }
        return maxSumProfit;
    }
}
