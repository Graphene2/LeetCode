package DP;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 9:31
 */
public class lc70爬楼梯 {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        if (n == 1) return 1;
        if (n == 2) return 2;
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
    // 改进版，改进空间复杂度
    public int climbStairs2(int n){
        int pre1 = 0, pre2 = 0;
        int cur = 1;
        for (int i = 1; i <= n; i++){
            pre2 = pre1;
            pre1 = cur;
            cur = pre1 + pre2;
        }
        return cur;
    }
}
