package DP;

/**
 * Description:1. 第一遍，这个题依赖于完全背包问题的模板。
 * User: zhangcheng
 * Date: 2020-11-25
 * Time: 19:59
 */
public class lc518零钱兑换II {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0){
            if (amount == 0){
                return 1;
            }else {
                return 0;
            }
        }
        // dp[i][j] 表示前i个硬币达到j的钱数的凑钱方法。
        int[][] dp = new int[len + 1][amount + 1];
        // 思考初始值，dp[0][...] 表示0个硬币凑钱方法为0;
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }
        // dp[...][0] 表示凑钱到价值为0的组合数，均为1;
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        // 开始进行状态转移:
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                // 选择当前硬币，凑钱组合数可用dp[i][j - coin[i]]表示，
                // 即重复选择当前硬币不会增加凑钱的组合数目。
                // 不选择当前硬币，凑钱组合数可用dp[i - 1][j]表示，
                // 即只用i-1个硬币凑齐价值为j的钱，那么就不选择当前硬币，组合数相同。
                if (j >= coins[i - 1]){
                    // 注意，硬币应该为coins[i - 1]表示第i个硬币。
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][amount];
    }
    // 通过方法1可知是可以有优化空间的、
    public int change2(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0){
            if (amount == 0){
                return 1;
            }else {
                return 0;
            }
        }
        // 这里dp[j]表示凑齐j的价值的组合数目。
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            // 这里从前往后进行遍历表示可以重复进行coin硬币的选取，如果当前硬币只能选一次的话需要从后往前遍历，
            // 最好的理解方法是进行列表然后进行思考。
            for (int j = 1; j <= amount ; j++) {
                if (j >= coins[i]){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
