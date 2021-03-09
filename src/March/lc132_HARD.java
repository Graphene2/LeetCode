package March;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-08
 * Time: 9:27
 */
public class lc132_HARD {
    public int minCut(String s) {
        int len = s.length();
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return 1;
        }
        char[] chars = s.toCharArray();
        // dp 表示作为在某个区间是否是回文串。
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right ; left++) {
                if (chars[left] == chars[right] && (right - left <= 2 || dp[left + 1][right - 1])){
                    dp[left][right] = true;
                }
            }
        }
        // fp 才是最终的答案, 即表示到当前位置最小的分割次数。
        int[] fp = new int[len];
        Arrays.fill(fp,Integer.MAX_VALUE);
        for (int right = 0; right < len; right++) {
            if (dp[0][right]){
                fp[right] = 0;
            }else {
                for (int left = 0; left < right; left++) {
                    if (dp[left + 1][right]){
                        fp[right] = Math.min(fp[right], fp[left] + 1);
                    }
                }
            }
        }
        return fp[len - 1];
    }
}
