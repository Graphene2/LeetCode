package March;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-17
 * Time: 10:32
 */
public class lc115不同的子序列 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (n == 0){
            return 1;
        }
        if (n > m){
            return 0;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        // 初始化，t为空时 对应 dp 全为1;
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (sChar[j - 1] == tChar[i - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
