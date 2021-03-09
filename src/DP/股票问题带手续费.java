package DP;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 21:52
 */
public class 股票问题带手续费 {
    public int maxProfit(int[] prices, int fee){
        if (prices == null || prices.length == 0) return 0;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            // 该题中k为无穷大，故而k和k-1是相同的，省去一个状态标志
            // 新状态只与相邻的状态有关，故而只需要两个变量存储所需的状态就够了。
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
