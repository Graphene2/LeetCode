package January;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-14
 * Time: 14:11
 */
public class hard_lc312戳气球 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n + 2 - len ; i++) {
                int res = 0;
                for (int k = i + 1; k < i + len - 1 ; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res,left + temp[i] * temp[k] * temp[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }
        return dp[0][n + 1];
    }
}
