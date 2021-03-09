package DP;

/**
 * Description:常见dp题目，主要以
 * User: zhangcheng
 * Date: 2020-11-04
 * Time: 17:15
 */
public class lc91解码方法 {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0){
            return 0;
        }
        int[] dp = new int[len];
        char[] ch = s.toCharArray();
        if (ch[0] == '0'){
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ch[i] != '0'){
                dp[i] = dp[i - 1];
            }
            int num = 10 * (ch[i - 1] - '0') + ch[i] - '0';
            if (10 <= num && num <= 26){
                if (i == 1){
                    dp[i] += dp[i - 1];
                }else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }
}
