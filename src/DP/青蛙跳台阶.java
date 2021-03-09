package DP;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 19:22
 */
public class 青蛙跳台阶 {
    public int JumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= target; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
