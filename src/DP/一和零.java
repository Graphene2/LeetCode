package DP;

/**
 * Description:lc474 一和零
 * User: zhangcheng
 * Date: 2020-10-09
 * Time: 18:52
 */
public class 一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // 为了避免分类讨论，这里设置第0个字符串为空串，字符串为空即dp[0][.][.]为0;
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs){
            int[] cnt = CountZeroAndOne(s);
            int zeros = cnt[0];
            int ones = cnt[1];
            for (int j = m; j >= zeros; j--){
                for (int k = n; k >= ones; k--){

                    if (j >= zeros && k >= ones){
                        dp[j][k] = Math.max(dp[j][k],dp[j - zeros][k - ones] + 1);
                    }
                }

            }
        }
        return dp[m][n];
    }

    private int[] CountZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()){
            cnt[c - '0']++;
        }
        return cnt;
    }


}
