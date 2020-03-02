package joy.leetcode.dp;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i - 1];
            maxCur = Math.max(0, maxCur);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static int maxProfit2(int[] prices) {
        // 其实就是MaximumSunarray的算法。
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int[] profits = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            profits[i - 1] = prices[i] - prices[i - 1];
        }
        int maxCur = 0, maxSoFar = 0;
        for (int i = 0; i < profits.length; i++) {
            maxCur = Math.max(maxCur + profits[i], profits[i]);
            maxSoFar = Math.max(maxSoFar, maxCur);
        }
        return maxSoFar;
    }

    public static int maxProfit3(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            maxCur = Math.max(profit, profit + maxCur);
            maxSoFar = Math.max(maxSoFar, maxCur);
        }
        return maxSoFar;
    }

}
