package joy.leetcode.dp;

import java.util.Arrays;

/*
* 一个理解上的坑：https://leetcode.com/problems/min-cost-climbing-stairs/discuss/148907/Doubt
* 即top of stair not the last element
* 讲解：https://www.cnblogs.com/grandyang/p/8343874.html
* */
public class MiniCostClimbingStair {
    public static int miniCostClimbingStair(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i < n+1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {0, 0, 1, 1};
        int result = MiniCostClimbingStair.miniCostClimbingStair(cost);
        System.out.println(result);
    }
}
