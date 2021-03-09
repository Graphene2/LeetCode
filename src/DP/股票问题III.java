package DP;

/**
 * Description:lc123买卖股票的最佳时机 III
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 21:58
 */
public class 股票问题III {
    // 通用模式，动态规划
    /**框架为：
     * 当天利润最大为dp
     int[][] dp = new int[prices.length][2];
     初始化base case
     dp[0][0] = 0;
     dp[i][k][1] = - prices[i];
     dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
     今天没有持有股票的：1.前一天没有持有，今天保持rest  2.前一天持有，今天买掉，获得利润为今天的股价。
     dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
     今天持有股票：1.前一天持有，今天保持rest  2.前一天没有持有，今天买入，利润减去今天的股价
     dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);
     dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);

     dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
     dp[i][1][1] = Math.max(dp[i-1][1][1], - prices[i]);
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            dp_i20 = Math.max(dp_i20,dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21,dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10,dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11,-prices[i]);
        }
        return dp_i20;
    }
}
