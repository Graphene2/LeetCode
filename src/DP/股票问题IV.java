package DP;

/**
 * Description:lc88股票问题带交易次数限制K
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 22:24
 */
public class 股票问题IV {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        // 当k非常大时转为无限次交易
        if (k >= n / 2){
            int dp_i_0 = 0, dp_i_1 = -prices[0];
            for (int i = 0; i < n; i++){
                int tmp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
            }
            return dp_i_0;
        }
        // 定义二维数组，交易了多少次、当前的买卖状态
        int[][][] dp = new int[n][k+1][2];
        for (int i = 1; i <= k; i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = k; j > 0; j--){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
