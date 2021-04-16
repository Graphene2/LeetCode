package JAVAFORMEETING;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-16
 * Time: 10:09
 */
public class lc87扰乱字符串 {
    public boolean isScramble(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        if (n != m){
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = chars1[i] == chars2[j];
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len ; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k <= len ; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]){
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]){
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
