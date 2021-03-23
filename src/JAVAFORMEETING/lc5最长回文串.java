package JAVAFORMEETING;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-11
 * Time: 19:55
 */
public class lc5最长回文串 {
    // 方法一：动态规划
    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i],false);
        }
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 0, start = 0;
        for (int r = 0; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) != s.charAt(r)){
                    dp[l][r] = false;
                }else {
                    if (r - l < 3){
                        dp[l][r] = true;
                    }else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }
                if (dp[l][r]){
                    int curLen = r - l + 1;
                    if (curLen > maxLen){
                        maxLen = curLen;
                        start = l;
                    }
                }
            }
        }
        return s.substring(start,start + maxLen + 1);
    }
    // 马拉车算法
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        String str = addBoundaries(s,'#');
        int sLen = 2 * len + 1;

        int[] p = new int[sLen];
        // 双指针
        int maxRight = 0;
        int center = 0;
        // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        int maxLen = 1;

        int start = 0;
        for (int i = 0; i < sLen; i++) {
            if (i < maxRight){
                // 当 p[mirror] < maxRight - i 时， p[i] = p[mirror];
                // 当 p[mirror] = maxRight - i 时， p[i] 至少为 p[mirror];
                // 当 p[mirror] > maxRight - i 时， p[i] = maxRight - i;
                int mirror = 2 * center - i;
                p[i] = Math.min(maxRight - i, p[mirror]);
            }
            // 如果i >= maxRight, 直接进行中心扩散获得 p[i]；
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);
            while (left >= 0 && right < sLen && str.charAt(left) == s.charAt(right)){
                p[i]++;
                left--;
                right++;
            }
            if (i + p[i] > maxRight){
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen){
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start,start + maxLen);


    }

    private int centerSpread(String str, int central) {
        int len = str.length();
        int i = central - 1;
        int j = central + 1;
        int step = 0;
        while (i >= 0 && j < len && str.charAt(i) == str.charAt(j)){
            step++;
            i--;
            j++;
        }
        return step;

    }

    private String addBoundaries(String s, char c) {
        int len = s.length();
        if (len == 0){
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(c);
            sb.append(s.charAt(i));
        }
        sb.append(c);
        return sb.toString();
    }
}
