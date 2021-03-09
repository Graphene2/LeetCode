package DP;

/**
 * Description:动态规划
 * User: zhangcheng
 * Date: 2020-10-27
 * Time: 15:17
 */
public class hard_lc10正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        // 首先进行一定的分析判断
        // f[i][j] 表示s的前i个字符和p的前j个字符是否匹配。
        // 我们要根据p[j]的状态进行分析，
        // 如果
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }else {
                    if (matches(s,p,i,j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);

    }
}
