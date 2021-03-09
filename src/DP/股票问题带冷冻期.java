package DP;

/**
 * Description: lc309题，
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 21:42
 */
public class 股票问题带冷冻期 {
    // 通用模式，动态规划
    /**框架为：
     * 当天利润最大为dp
     int[][] dp = new int[prices.length][2];
     初始化base case
     dp[0][0] = 0;
     dp[i][k][1] = - prices[i];
     dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
     今天没有持有股票的：1.前一天没有持有，今天保持rest
     2.前一天持有，今天买掉，获得利润为今天的股价。
     dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k-1][0] - prices[i]);
     今天持有股票：1.前一天持有，今天保持rest
     2.前一天没有持有，今天买入，利润减去今天的股价
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int ans = 0;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表dp[i-2][0]
        for (int i = 0; i < prices.length; i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
