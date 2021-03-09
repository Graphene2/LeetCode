package DP;

/**
 * Description:剑指offer39
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 19:35
 */
public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int ans = 0;
        int curMin = prices[0];
        for (int i = 1; i < prices.length; i++){
            curMin = Math.min(curMin,prices[i]);
            ans = Math.max(ans,prices[i] - curMin);
        }
        return ans;
    }
}
