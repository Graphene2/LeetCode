package DP;

import java.util.Arrays;

/**
 * Description:1. 完成第一遍！
 * 2.
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 19:07
 */
public class acwing_01背包问题 {
    // W 为背包最大可承受/体积，N 为物品个数，wt为每个物品的重量，val为每个物品的体积。
    int knapsack(int W, int N, int[] wt, int[] val){
        int[][] dp = new int[N + 1][W + 1];
        Arrays.fill(dp,0);
        // dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= W; j++){
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    // 装入或者不装入背包，择优
                    dp[i][j] = Math.max(dp[i - 1][j],
                                    dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }
    // 优化，其中只用到了dp[i-1][j];在心中画一个表格对应的dp[i][j]这个数组，
    // 所以对于二维数组进行优化成一位数组的时候需要特别注意：从大到小进行更新。
    int knapsack2(int V, int N, int[] vol, int[] valve){
        int[] dp = new int[V + 1];
        Arrays.fill(dp,0);
        // dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
        for (int i = 1; i <= N; i++){
            for (int j = V; j >= 0; j--){
                dp[j] = Math.max(dp[j],dp[j - vol[i]] + valve[i]);
            }
        }
        return dp[V];
    }

}
