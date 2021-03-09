package DP;

import java.util.Arrays;

/**
 * Description:1.第一遍
 * 2.第二遍还是不怎么会额
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 16:19
 */
public class DP322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 0; i < max; i++){
            for (int coin : coins){
                if (i >= coin) {
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1);
                }
            }
        }
        return (dp[amount] == max)? -1 : dp[amount];
    }
}
