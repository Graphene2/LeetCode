package DP;


/**
 * Description: 不限次数交易寻找最大利润
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 19:44
 */
public class lc121股票问题II {
    // 最优方法：贪心
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++){
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) res += tmp;
        }
        return res;
    }
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
    public int maxProfit2(int[] prices){
        if (prices == null || prices.length == 0) return 0;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            // 该题中k为无穷大，故而k和k-1是相同的，省去一个状态标志
            // 新状态只与相邻的状态有关，故而只需要两个变量存储所需的状态就够了。
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }
        return dp_i_0;
    }
}
