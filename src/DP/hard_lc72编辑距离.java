package DP;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-30
 * Time: 10:03-10:16
 */
public class hard_lc72编辑距离 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0){
            return n + m;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int temp = dp[i - 1][j - 1];
                if (word1.charAt(i) != word2.charAt(j)){
                    temp++;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(temp,dp[i][j - 1] + 1));
            }
        }
        return dp[m + 1][n + 1];
    }
}
